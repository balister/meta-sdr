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

PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/gr-vt/gr-message_tools;branch=master \
           file://0001-Boost-1.67-compatibility.patch \
          "

S = "${WORKDIR}/git"

SRCREV = "f96c4b93457d5cab5ad7dfffbe575e60124ba447"
