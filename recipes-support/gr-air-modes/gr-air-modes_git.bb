SUMMARY = "A mode S receiver for GNU Radio."
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio sqlite3 gr-osmosdr"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/bistromath/gr-air-modes \
          "
S = "${WORKDIR}/git"

SRCREV = "719d52b6dd6a88a809245ea26a759263426548d4"
