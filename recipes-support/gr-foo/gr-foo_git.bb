SUMMARY = "This out of tree module contains a number of blocks to help perform mapping between bits and symbols"
HOMEPAGE = "https://github.com/gr-vt/gr-mapper"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=3273935b74fae1d26432b0aa26ef796d"


DEPENDS = "gnuradio log4cpp cppunit swig-native python3-pybind11-native  python3-native python3-numpy-native"
RDEPENDS_${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bastibl/gr-foo;branch=maint-3.9;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "cc8bfc6e4e238a1d4f08ad14ee594d993d333fd3"

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
