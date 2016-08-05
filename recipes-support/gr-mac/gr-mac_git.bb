SUMMARY = "Easy-to-use MAC-layer implementations for GNU Radio."
HOMEPAGE = "https://github.com/jmalsbury/gr-mac"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=e84f563988fbb5a8798ffd8f9d28febf"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/jmalsbury/gr-mac;branch=master \
           file://cross-64.patch \
           file://0001-Use-CMAKE_INSTALL_LIBDIR-to-set-LIB_SUFFIX.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "3ed6f0893341f48fc7fb000ca1cf679524b033a4"
