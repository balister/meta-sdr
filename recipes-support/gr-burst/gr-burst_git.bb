SUMMARY = "This out of tree module contains a number of blocks which help enable building simple burst PSK modems in GNU Radio."
HOMEPAGE = "https://github.com/gr-vt/gr-burst"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio volk python-bitarray gr-eventstream gr-mapper"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.3+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-burst;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "f0f6c99563e82226b83bfc99d152b1036174ceec"
