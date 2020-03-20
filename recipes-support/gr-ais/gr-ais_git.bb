SUMMARY = "Automatic Information System decoder for shipborne position reporting for the Gnuradio project"
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=0ad29e89f2e64b6025da4cf91d2055fb"

DEPENDS = "gnuradio swig-native"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.3+git${SRCPV}"

SRC_URI = "git://github.com/bistromath/gr-ais;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "1863d1bf8a7709a8dfedb3ddb8e2b99112e7c872"
