SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/ghostop14/gr-mesa"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=e975a76e3748de0c654a7ef82bce210f"


DEPENDS = "gnuradio cppunit swig-native python3-pybind11-native spdlog gr-lfast  python3-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

PACKAGECONFIG ??= "qt4"

PACKAGECONFIG[qt4] = "-DENABLE_QT=ON,-DENABLE_QT=OFF,qtbase qwt-qt5 python3-pyqt5, "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/ghostop14/gr-mesa;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "5a4d745fa27f5a7d332c2b10ccc1c634e81969e2"

EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
