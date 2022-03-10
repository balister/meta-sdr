SUMMARY = "gr-satellites gnuradio block set from EA4GPZ"
HOMEPAGE = "https://github.com/daniestevez/gr-satellites"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "gnuradio swig-native orc"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.2.0"

EXTRA_OECMAKE = " -DPYTHON_EXECUTABLE=/usr/bin/python3.8 "

GIT_BRANCH = "maint-3.8"

SRC_URI = "git://github.com/daniestevez/gr-satellites;branch=${GIT_BRANCH};protocol=http"

SRC_URI[sha256sum] = "ca86ac2bf65e560fad839891e528c31814ba0964365f30baaf4673d3b58bd6e3"

S = "${WORKDIR}/git"

SRCREV = "f732e24e4c139d26be76cf61d61c0402b1f62fad"
