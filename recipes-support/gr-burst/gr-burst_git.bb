SUMMARY = "This out of tree module contains a number of blocks which help enable building simple burst PSK modems in GNU Radio."
HOMEPAGE = "https://github.com/gr-vt/gr-burst"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio volk"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-burst;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "2a6f865d35ae60c34527ca2032163264ef817b05"
