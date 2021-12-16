SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/gr-vt/gr-mapper"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio log4cpp cppunit swig-native"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-mapper;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "39ebd611406a53ac2f4c0e7dcbbf74cf68ba1cb5"
