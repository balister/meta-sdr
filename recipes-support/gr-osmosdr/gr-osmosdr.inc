DESCRIPTION = "osmocomSDR gnuradio block set"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/GrOsmoSDR"
LICENSE = "GPLv3"
SECTION =  "apps"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libusb1 gnuradio rtl-sdr"
RDEPENDS_${PN} += "libusb1 gnuradio rtl-sdr"

PE = "1"
INC_PR = "r1"

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

PACKAGES += ""

INSANE_SKIP_${PN} = "dev-so"

FILES_${PN} += "${libdir}/* \
                ${bindir}/*  \
                ${datadir}/gnuradio/grc/blocks/*"
            

                      



OECMAKE_BUILDPATH = "${S}/build"
OECMAKE_SOURCEPATH = "${S}"

PACKAGECONFIG = "-DENABLE_NETSDR=OFF"


EXTRA_OECMAKE = "-DENABLE_NETSDR=OFF"

EXTRA_OEMAKE = "-C ${OECMAKE_BUILDPATH}"
