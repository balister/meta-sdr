SUMMARY = "Software to turn the RTL2832U into a SDR"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/rtl-sdr"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libusb1"

PV = "0.6.0"

SRC_URI = "git://git.osmocom.org/rtl-sdr \
           file://0001-Do-not-store-build-system-CFLAGS-in-the-pkgconfig-fi.patch \
          "
SRCREV = "1f0eafe60445339703903af6d8814ffab7e73784"

S = "${WORKDIR}/git"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--enable-driver-detach"

do_install_append() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${S}/rtl-sdr.rules ${D}${sysconfdir}/udev/rules.d
}
