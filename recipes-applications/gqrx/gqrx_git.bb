SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr"

inherit cmake_qt5

PV = "2.6.1+"

SRC_URI = "git://github.com/csete/gqrx.git \
          "
S = "${WORKDIR}/git"

SRCREV = "09f89e4c384bb39258b52c286febc51d8e75e2eb"

EXTRA_OECMAKE = "-DLINUX_AUDIO_BACKEND=Gr-audio"

#RDEPENDS_${PN} = "qt4-plugin-imageformat-svg"

