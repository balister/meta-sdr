SUMMARY = "Collection of Advanced GNURadio Processing Blocks - Autodoppler, input selection, and signal detection"
HOMEPAGE = "https://github.com/ghostop14/gr-mesa"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-or-later;md5=1c76c4cc354acaac30ed4d5eefea7245"


DEPENDS = "gnuradio volk log4cpp cppunit  python3-pybind11-native  python3-numpy-native spdlog gr-lfast"
RDEPENDS:${PN} = "gnuradio python3-click volk"

inherit gnuradio-oot


PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/ghostop14/gr-mesa;branch=master;protocol=https \
           "
SRCREV = "1840556948343d2398721f1bd23c1f42b389f136"

