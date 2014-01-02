SUMMARY = "SDR powered by GNU Radio and Qt"
HOMEPAGE = "http://gqrx.dk/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

inherit qt4x11

PV = "2.2.0+2.2.xgit"

SRC_URI = "git://github.com/csete/gqrx.git;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "d97bd72879939ebf314637068218335d5005f3fe"

EXTRA_QMAKEVARS_PRE="PREFIX="${prefix}""

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}
