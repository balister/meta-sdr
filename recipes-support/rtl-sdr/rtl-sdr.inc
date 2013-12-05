DESCRIPTION = "DVB-T dongles based on the Realtek RTL2832U as a SDR"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/rtl-sdr"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libusb1"
RDEPENDS_${PN} += "libusb1"

PE = "1"
INC_PR = "r1"

inherit cmake pythonnative



INSANE_SKIP_${PN} = "dev-so"

FILES_${PN} += "${libdir}/* \
                ${bindir}/*  "



OECMAKE_BUILDPATH = "${S}/build"
OECMAKE_SOURCEPATH = "${S}"

PACKAGECONFIG ??= ""


EXTRA_OEMAKE = "-C ${OECMAKE_BUILDPATH}"
