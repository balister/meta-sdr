SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/gr-vt/gr-mapper"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-mapper;branch=master \
           file://cross-64.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "ee5cd7f63218288c521cfb6af1a00d1391e688a3"
