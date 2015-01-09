SUMMARY = "Automatic Information System decoder for shipborne position reporting for the Gnuradio project"
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=28e44a01e2ae0b3f9e7f8487f67203a2"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/bistromath/gr-ais;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "7fdfc4d24b7bd44456a1734ae4d934af56a17475"
