SUMMARY = "OsmocomSDR gnuradio block set"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/GrOsmoSDR"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio uhd rtl-sdr"

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.1.0+git"

SRC_URI = "git://git.osmocom.org/gr-osmosdr;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "05d51b5340496036b69ef4fbbce6a1983a4b81ba"
