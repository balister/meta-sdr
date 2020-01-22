SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr"

inherit cmake_qt5

PV = "2.11.5+"

SRC_URI = "git://github.com/csete/gqrx.git \
          "
S = "${WORKDIR}/git"

SRCREV = "34333e78b2e565745b6d62bf0efcc57cc3b1988f"

EXTRA_OECMAKE = "-DLINUX_AUDIO_BACKEND=Gr-audio \
                "

#RDEPENDS_${PN} = "qt4-plugin-imageformat-svg"

