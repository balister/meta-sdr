SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr qtsvg"

inherit cmake_qt5

PV = "2.15.9"

SRC_URI = "git://github.com/gqrx-sdr/gqrx.git;branch=master;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "c8b57ef5a4f83d918c02bf73f1b5cfaebdc7e880"

EXTRA_OECMAKE = "-DLINUX_AUDIO_BACKEND=Gr-audio \
                "

FILES:${PN} += "${datadir}"

#RDEPENDS:${PN} = "qt4-plugin-imageformat-svg"

