SUMMARY = "GNU Radio Event Stream"
HOMEPAGE = "https://github.com/osh/gr-eventstream"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://README;md5=94b072ac07d7c0f9b55acc17dc656824"

DEPENDS = "gnuradio log4cpp"

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.3+git${SRCPV}"

SRC_URI = "git://github.com/osh/gr-eventstream;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "ce9c17bce62878a85d4881b0d89ce28e5dc82195"
