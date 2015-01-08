SUMMARY = "Collection of new blocks for GNU Radio"
HOMEPAGE = "http://wiki.spench.net/wiki/gr-baz"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

inherit setuptools cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/balint256/gr-baz;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "ce84fbdc32776f4f949a19ee56c4c7c9fc002885"
