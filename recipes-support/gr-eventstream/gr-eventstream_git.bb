SUMMARY = "GNU Radio Event Stream"
HOMEPAGE = "https://github.com/osh/gr-eventstream"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://README;md5=94b072ac07d7c0f9b55acc17dc656824"

DEPENDS = "gnuradio"

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.1.0+git"

SRC_URI = "git://github.com/osh/gr-eventstream;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "a8442f03eaefdce3ead0698b6c0d91a5df606223"
