SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/ghostop14/gr-lfast"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=199395d4cfeccfa8d19daae1337625bb"


DEPENDS = "gnuradio volk log4cpp cppunit swig-native python3-pybind11-native python3-native python3-numpy-native spdlog"
RDEPENDS_${PN} = "gnuradio python3-click volk"

inherit setuptools3 cmake pkgconfig python3native


export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/ghostop14/gr-lfast;branch=master;protocol=https \
           file://0001-adding-neon-support.patch \
           "
S = "${WORKDIR}/git"

SRCREV = "63b1e185ea09453e7f287bae8a62924c868c6b33"

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
