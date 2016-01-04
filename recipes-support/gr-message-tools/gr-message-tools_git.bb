SUMMARY = "This is a OOTM to help with simple debugging with the PMT messages."
HOMEPAGE = "https://github.com/gr-vt/gr-message_tools"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-message_tools;branch=master \
           file://cross-64.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "c4ed7e3c1e4ab7bf19e5c660682b11c22f28f261"
