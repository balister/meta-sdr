SUMMARY = "gr-satellites is a GNU Radio out-of-tree module encompassing a collection of telemetry decoders that supports many different Amateur satellites."
HOMEPAGE = "https://github.com/daniestevez/gr-satellites"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "gnuradio python3 cppunit python3-pybind11-native python3-native python3-numpy-native spdlog python3-construct python3-requests orc orc-native feh"
RDEPENDS:${PN} = "gnuradio python3-click python3-construct python3-requests orc feh"

inherit setuptools3 cmake


export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/daniestevez/gr-satellites;branch=main;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "42148cf924861b72f9fd8ae23702435df208169d"

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
