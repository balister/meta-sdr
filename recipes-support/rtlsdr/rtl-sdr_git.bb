SUMMARY = "Software to turn the RTL2832U into a SDR"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/rtl-sdr"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libusb1"

PV = "0.5.1+git"

SRC_URI = "git://git.osmocom.org/rtl-sdr"
SRCREV = "a42659602deff728da6731928e660f90407bbbe0"

S = "${WORKDIR}/git"

inherit autotools lib_package

EXTRA_OECONF = "--enable-driver-detach"

do_install_append() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 rtl-sdr.rules ${D}${sysconfdir}/udev/rules.d
}
