SUMMARY = "The goal of the gr-lfast project is to increase flowgraph performance while running on a general purpose CPU. So far the project uses several techniques to achieve the performance boosts:"
HOMEPAGE = "https://github.com/ghostop14/gr-lfast"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "gnuradio volk log4cpp cppunit swig-native python3-pybind11-native python3-native python3-numpy-native spdlog"
RDEPENDS:${PN} = "gnuradio python3-click volk"

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

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
