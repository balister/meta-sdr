SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio gr-osmosdr"

inherit qt4x11

PV = "2.3.1"

SRC_URI = "git://github.com/csete/gqrx.git;branch=master \
           file://0001-Disable-pulseaudio.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "3af6570cdedbe31416adac9dc3cee713bf03cb69"

EXTRA_QMAKEVARS_PRE="PREFIX="${prefix}""

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}
