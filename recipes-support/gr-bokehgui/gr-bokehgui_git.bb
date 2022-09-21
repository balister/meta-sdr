SUMMARY = " GNU Radio web gui baased on bukeh."
HOMEPAGE = "https://github.com/GNU Radio/gr-bokehgui"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=d7acf93d587e896df02840e5cd9c56ea"

DEPENDS = "gnuradio python3-bokeh python3-bokeh-native python3-pybind11-native python3-packaging-native \
           python3-numpy python3-numpy-native python3-mako-native"
RDEPENDS_${PN} = "gnuradio python3-bokeh python3-click"

inherit distutils3-base cmake pkgconfig python3native mime mime-xdg ptest

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"



PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/gnuradio/gr-bokehgui;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "2be3889a3bda34427889654f0700cc4c547a2e05"

PYTHON_SITEPACKAGES_DIR_NATIVE = "${WORKDIR}/recipe-sysroot-native/usr/lib/${PYTHON_DIR}/site-packages"

EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=":PATH\${PYTHON_SITEPACKAGES_DIR_NATIVE}" \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    -DCMAKE_CROSSCOMPILING=ON \
    "

INSANE_SKIP_${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES_${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"