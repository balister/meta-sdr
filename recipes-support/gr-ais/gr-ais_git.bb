SUMMARY = "Automatic Information System decoder for shipborne position reporting for the Gnuradio project"
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=2f64aa5c06f8d667b76f72180213a1f0"

DEPENDS = "gnuradio python3-pybind11-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio"

inherit setuptools3 cmake python3native 

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES:${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.3+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-ais;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "fd72dd564470f55eea664271a026c892c69c6784"

PYTHON_MAJMIN = "3.12"

EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/python${PYTHON_MAJMIN} \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
