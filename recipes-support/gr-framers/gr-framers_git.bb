SUMMARY = "This out of tree module contains several different framers and deframers which may be used with GNU Radio flowgraphs"
HOMEPAGE = "https://github.com/gr-vt/gr-framers"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.1+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-framers;branch=master \
           file://0001-Fix-lib64-detection-for-cross-compiling.patch \
           file://0002-Fix-OpenEmbedded-builds-for-targets-that-use-lib64.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "eff609888426d6257ea2756aec9d704bb3fbc54f"
