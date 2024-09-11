SUMMARY = "Collection of Advanced GNURadio Processing Blocks - Autodoppler, input selection, and signal detection"
HOMEPAGE = "https://github.com/ghostop14/gr-mesa"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-or-later;md5=1c76c4cc354acaac30ed4d5eefea7245"


DEPENDS = "gnuradio volk log4cpp cppunit swig-native python3-pybind11-native python3-native python3-numpy-native spdlog gr-lfast"
RDEPENDS:${PN} = "gnuradio python3-click volk"

inherit setuptools3 cmake pkgconfig python3native


export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/ghostop14/gr-mesa;branch=master;protocol=https \
           "
S = "${WORKDIR}/git"

SRCREV = "1840556948343d2398721f1bd23c1f42b389f136"
PYTHON_MAJMIN = "3.12"

EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/python${PYTHON_MAJMIN} \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DENABLE_DOXYGEN=OFF \
     ${@bb.utils.contains('TUNE_FEATURES', 'neon', \
                     '-Dhave_mfpu_neon=1', '-Dhave_mfpu_neon=0', d)} \
    "

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
