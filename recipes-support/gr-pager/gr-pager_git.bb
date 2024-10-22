SUMMARY = "This is an out-of-tree (OOT) module for GNU Radio which can demodulate and decode Motorola FLEX radiopager signals. "
HOMEPAGE = "https://github.com/troycurtisjr/gr-pager"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"


DEPENDS = "gnuradio log4cpp cppunit swig-native python3-pybind11-native  python3-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-pager.git;branch=maint-3.10;protocol=https \
          "
SRCREV = "7df10f41709af2841058a7f42b3d641ee508d10e"

S = "${WORKDIR}/git"

PYTHON_MAJMIN = "3.12"


EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/python${PYTHON_MAJMIN} \
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
