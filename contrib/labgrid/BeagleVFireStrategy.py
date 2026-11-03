"""labgrid strategy for the BeagleBoard BeagleV-Fire (Microchip PolarFire SoC).

The eMMC is flashed via the Hart Software Services (HSS) zero-stage
bootloader. Its CLI command ``usbdmsc`` exposes the eMMC as a USB mass
storage device on the board's USB-C port, so no SD mux or boot-mode
jumpers are needed:

  1. power on with the serial console open
  2. press a key during HSS's "Press a key to enter CLI" countdown
  3. run ``mmc`` then ``usbdmsc``; the eMMC appears on the exporter as
     a block device (the USBMassStorage resource)
  4. write the wic image with bmaptool
  5. Ctrl-C out of usbdmsc and power cycle; HSS boots from the eMMC
"""

import enum

import attr

from pexpect import TIMEOUT

from labgrid.factory import target_factory
from labgrid.strategy.common import Strategy, StrategyError
from labgrid.driver.usbstoragedriver import Mode
from labgrid.step import step


class Status(enum.Enum):
    unknown = 0
    off = 1
    flashed = 2
    shell = 3


@target_factory.reg_driver
@attr.s(eq=False)
class BeagleVFireStrategy(Strategy):
    """BeagleVFireStrategy - flash the eMMC through HSS usbdmsc and boot to a shell"""
    bindings = {
        "power": "PowerProtocol",
        "console": "ConsoleProtocol",
        "storage": "USBStorageDriver",
        "shell": "ShellDriver",
    }

    status = attr.ib(default=Status.unknown)

    # Name of the image in the environment's "images:" section.
    image = attr.ib(default="emmc_image", validator=attr.validators.instance_of(str))
    # HSS prints this, then waits about 5 s before booting the payload.
    hss_autoboot_prompt = attr.ib(default="Press a key to enter CLI",
                                  validator=attr.validators.instance_of(str))
    hss_prompt = attr.ib(default=">> ", validator=attr.validators.instance_of(str))
    # Time from power on to the HSS countdown.
    hss_timeout = attr.ib(default=60, validator=attr.validators.instance_of(int))
    # Time for the eMMC to enumerate on the exporter after "usbdmsc".
    usb_timeout = attr.ib(default=60.0, validator=attr.validators.instance_of(float))
    # Retries when the board does not reach a login prompt.
    boot_attempts = attr.ib(default=3, validator=attr.validators.instance_of(int))

    def __attrs_post_init__(self):
        super().__attrs_post_init__()

    def _power_on_and_stop_in_hss(self):
        """Power cycle the board and interrupt HSS autoboot at its CLI."""
        self.target.activate(self.console)
        self.target.activate(self.power)
        self.power.off()
        self.power.on()
        self.console.expect(self.hss_autoboot_prompt, timeout=self.hss_timeout)
        self.console.write(b"\r")
        self.console.expect(self.hss_prompt, timeout=10)

    @step(title="flash eMMC")
    def flash(self):
        """Write the configured image to the eMMC and leave the board off."""
        image = self.target.env.config.get_image_path(self.image)

        self._power_on_and_stop_in_hss()

        # Select the eMMC, then export it over USB.
        self.console.sendline("mmc")
        self.console.expect(self.hss_prompt, timeout=10)
        self.console.sendline("usbdmsc")

        # The USBMassStorage resource only exists while usbdmsc is running.
        self.target.await_resources([self.storage.storage], timeout=self.usb_timeout)
        try:
            self.target.activate(self.storage)
            self.storage.write_image(image, mode=Mode.BMAPTOOL)
        finally:
            self.target.deactivate(self.storage)
            # Leave usbdmsc so HSS detaches cleanly before power off.
            self.console.sendcontrol("c")
            try:
                self.console.expect(self.hss_prompt, timeout=10)
            except TIMEOUT:
                self.logger.warning("HSS did not return to its prompt after usbdmsc")

        self.power.off()

    def transition(self, status):
        if not isinstance(status, Status):
            status = Status[status]
        if status == Status.unknown:
            raise StrategyError(f"can not transition to {status}")
        elif status == self.status:
            return # nothing to do
        elif status == Status.off:
            self.target.deactivate(self.shell)
            self.target.activate(self.power)
            self.power.off()
        elif status == Status.flashed:
            self.transition(Status.off)
            self.flash()
        elif status == Status.shell:
            if self.status != Status.flashed:
                self.transition(Status.flashed)

            self.target.activate(self.console)
            attempt = 0
            while True:
                try:
                    # Power on and let HSS autoboot from the eMMC.
                    self.power.cycle()
                    self.target.activate(self.shell)
                    break
                except TIMEOUT:
                    attempt += 1
                    if attempt == self.boot_attempts:
                        raise
            self.shell.run("systemctl is-system-running --wait", timeout=600)
        else:
            raise StrategyError(f"no transition found from {self.status} to {status}")
        self.status = status

    def force(self, status):
        if not isinstance(status, Status):
            status = Status[status]
        if status == Status.off:
            self.target.activate(self.power)
        elif status == Status.shell:
            self.target.activate(self.shell)
        else:
            raise StrategyError(f"can not force state {status}")
        self.status = status
