SUMMARY = "This out of tree module contains a number of blocks which help enable building simple burst PSK modems in GNU Radio."
HOMEPAGE = "https://github.com/gr-vt/gr-burst"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio volk python-bitarray gr-eventstream gr-mapper swig-native"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.5+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-burst;branch=master \
           file://cross-64.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "4d1683235f3bf864a87403f4c2ef116a6cbffa91"
