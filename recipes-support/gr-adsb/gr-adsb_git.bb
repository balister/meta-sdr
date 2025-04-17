SUMMARY = "A GNU Radio out-of-tree (OOT) module to demodulate and decode Automatic Dependent Surveillance Broadcast (ADS-B) messages"
HOMEPAGE = "https://github.com/mhostetter/gr-adsb"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "gnuradio gr-foo log4cpp cppunit python3-pybind11-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake python3native

export BUILD_SYS
export HOST_SYS = "${MULTIMACH_TARGET_SYS}"


PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-adsb;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "a35d5d6d7ac5fc091d121694ac51d600e77e44de"

EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DENABLE_DOXYGEN=OFF \
    "

#INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
