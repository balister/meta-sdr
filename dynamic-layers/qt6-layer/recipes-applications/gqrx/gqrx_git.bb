SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "https://gqrx.dk/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr qtbase qtsvg"

inherit qt6-cmake

PV = "2.17.7"

SRC_URI = "git://github.com/gqrx-sdr/gqrx.git;branch=master;protocol=https \
          "

SRCREV = "1a8ab3a3cc02db3bf4c9058ed4b60ddad06fe9d1"

EXTRA_OECMAKE = "-DLINUX_AUDIO_BACKEND=Gr-audio \
                 -DFORCE_QT6=ON \
                "

FILES:${PN} += "${datadir}"

RDEPENDS:${PN} = "gnuradio-audio qtbase-plugins qtsvg-plugins"
