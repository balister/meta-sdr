SUMMARY = "Software to turn the RTL2832U into a SDR"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/rtl-sdr"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libusb1"

PV = "2.0.2"

SRC_URI = "git://gitea.osmocom.org/sdr/rtl-sdr.git;branch=master;protocol=https \
          "
SRCREV = "619ac3186ea0ffc092615e1f59f7397e5e6f668c"

S = "${WORKDIR}/git"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--enable-driver-detach"

do_install:append() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${S}/rtl-sdr.rules ${D}${sysconfdir}/udev/rules.d
}
