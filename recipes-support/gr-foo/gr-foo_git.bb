SUMMARY = "This is a collection of custom blocks that are not directly associated with a project. "
HOMEPAGE = "https://github.com/bastibl/gr-foo/tree/maint-3.10"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "gnuradio log4cpp cppunit python3-pybind11-native  python3-numpy-native"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake python3native

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bastibl/gr-foo;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "0a34f68565863218c3c010e69f6bd6a9bdfd7142"
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
