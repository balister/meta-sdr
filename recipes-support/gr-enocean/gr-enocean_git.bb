SUMMARY = "This out of tree module contains blocks for processing the gr-eonocean waveform"
HOMEPAGE = "https://github.com/redwiretechnologies/gr-enocean"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=3ded9925873b252e2fdd245f496b6a65"


DEPENDS = "gnuradio log4cpp cppunit python3-pybind11-native python3-native python3-numpy-native "
RDEPENDS:${PN} = "gnuradio python3-click python3-enocean"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/redwiretechnologies/gr-enocean;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "de5a46ccbb6f6ba53c5b8ae8ad2a3fa85348d2c9"

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
