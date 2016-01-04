SUMMARY = "A mode S receiver for GNU Radio."
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio sqlite3 gr-osmosdr"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/balister/gr-air-modes;branch=e310-updates \
          "
S = "${WORKDIR}/git"

SRCREV = "e82cf9d4de2467a92429a5a2ed1e9c3a56884905"
