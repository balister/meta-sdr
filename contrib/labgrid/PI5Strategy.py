import enum

import attr

from pexpect import TIMEOUT

from labgrid.factory import target_factory
from labgrid.strategy.common import Strategy, StrategyError
from labgrid.driver.usbstoragedriver import Mode

class Status(enum.Enum):
    unknown = 0
    off = 1
    shell = 2


@target_factory.reg_driver
@attr.s(eq=False)
class PI5Strategy(Strategy):
    """PI5Strategy - Strategy to bootstrap and switch to shell"""
    bindings = {
        "power": "PowerProtocol",
        "sdmux": "USBSDMuxDriver",
        "storage": "USBStorageDriver",
        "console": "ConsoleProtocol",
        "shell": "ShellDriver",
    }

    status = attr.ib(default=Status.unknown)
    flashed = False

    def __attrs_post_init__(self):
        super().__attrs_post_init__()

    def bootstrap(self):
        self.target.activate(self.sdmux)
        self.sdmux.set_mode("host")
 
#        self.flashed = True
        if not self.flashed:
            self.target.activate(self.storage)
            image = self.target.env.config.get_image_path("sd_image")
            self.storage.write_image(image, mode=Mode.BMAPTOOL)
            self.target.deactivate(self.storage)
            self.flashed = True

        self.sdmux.set_mode("dut")

    def transition(self, status):
        if not isinstance(status, Status):
            status = Status[status]
        if status == Status.unknown:
            raise StrategyError(f"can not transition to {status}")
        elif status == self.status:
            return # nothing to do
        elif status == Status.off:
            self.target.deactivate(self.console)
            self.target.activate(self.power)
            self.power.off()
        elif status == Status.shell:
            self.transition(Status.off)

            self.bootstrap()

            self.target.activate(self.console)
            # cycle power
            timeout_count = 0
            while True:
                try:
                    self.power.cycle()
                    self.target.activate(self.shell)
                    break
                except TIMEOUT:
                    timeout_count += 1
                    if timeout_count == 3:
                        raise
            self.shell.run("systemctl is-system-running --wait")
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

