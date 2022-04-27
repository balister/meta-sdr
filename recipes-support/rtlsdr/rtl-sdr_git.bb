SUMMARY = "Software to turn the RTL2832U into a SDR"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/rtl-sdr"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libusb1"

PV = "0.6.0+git"

SRC_URI = "git://git.osmocom.org/rtl-sdr;branch=master;protocol=https \
          "
SRCREV = "dc92af01bf82b5185986190e3cde3762565d2194"

S = "${WORKDIR}/git"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--enable-driver-detach"

do_install:append() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${S}/rtl-sdr.rules ${D}${sysconfdir}/udev/rules.d
}
