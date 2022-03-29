SUMMARY = "gr-fpga_ai gnuradio block from S59MZ - RF modulation classification"
HOMEPAGE = "https://github.com/s59mz/gr-fpga_ai"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "gnuradio swig-native orc"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.2.0"

EXTRA_OECMAKE = " -DPYTHON_EXECUTABLE=/usr/bin/python3.8 "

GIT_BRANCH = "gr3.8"

SRC_URI = "git://github.com/s59mz/gr-fpga_ai;branch=${GIT_BRANCH};protocol=http"

S = "${WORKDIR}/git"

SRCREV = "a5d1b824264827f27bc67c1dfe63a4aa6b662230"
