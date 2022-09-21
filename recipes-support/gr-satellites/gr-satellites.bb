SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/ghostop14/gr-mesa"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "gnuradio python3 cppunit python3-pybind11-native python3-native python3-numpy-native spdlog python3-construct python3-requests orc orc-native feh"
RDEPENDS_${PN} = "gnuradio python3-click python3-construct python3-requests orc feh"

inherit setuptools3 cmake


export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/daniestevez/gr-satellites;branch=main;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "42148cf924861b72f9fd8ae23702435df208169d"

EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP_${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES_${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
