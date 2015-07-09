SUMMARY = "Automatic Information System decoder for shipborne position reporting for the Gnuradio project"
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=6c0f6d617107c431639fdc98c4e318c8"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/bistromath/gr-ais;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "56abd162cf4add878dbfa3bd60215001d4ae83ea"
