SUMMARY = "This is the fully-functional GNU Radio software-defined radio (SDR) implementation of a LoRa transceiver with all the necessary receiver components to operate correctly even at very low SNRs. This work has been conducted at the Telecommunication Circuits Laboratory, EPFL"
HOMEPAGE = "https://github.com/tapparelj/gr-lora_sdr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=8ad2a0a5a9277845fb953e76de029ec5"


DEPENDS = "gnuradio log4cpp cppunit python3-pybind11-native python3-native python3-numpy-native "
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/tapparelj/gr-lora_sdr.git;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "b53a3ba434df3150f4fb51a3e4bb1226caa51717"
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
    ${datadir}/gr-lora_sdr/examples/*.grc \
"
