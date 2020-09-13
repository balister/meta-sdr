SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr qtsvg"

inherit cmake_qt5

PV = "2.12.1"

SRC_URI = "git://github.com/csete/gqrx.git \
          "
S = "${WORKDIR}/git"

SRCREV = "9718d60c003b31a328b4457b400308c603e1518e"

EXTRA_OECMAKE = "-DLINUX_AUDIO_BACKEND=Gr-audio \
                "

#RDEPENDS_${PN} = "qt4-plugin-imageformat-svg"

