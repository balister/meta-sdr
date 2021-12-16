SUMMARY = "Collection of new blocks for GNU Radio"
HOMEPAGE = "http://wiki.spench.net/wiki/gr-baz"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio swig-native"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.7+git${SRCPV}"

SRC_URI = "git://github.com/balint256/gr-baz;branch=master;protocol=https \
           file://cross-64.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "77b143e2eeed530656e396f5d63e15128e560ecb"
