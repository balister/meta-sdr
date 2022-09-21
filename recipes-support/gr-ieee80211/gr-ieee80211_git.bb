SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/gr-ieee80211/gr-ieee802-11"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=3110fe5b9e99cdb2dcaa3d39493f9d93"


DEPENDS = "gnuradio gr-foo log4cpp cppunit swig-native python3-pybind11-native python3-native python3-numpy-native"
RDEPENDS_${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bastibl/gr-ieee802-11;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "56d8c5c19f64fb468397176ef52ea8c0a235e019"

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
