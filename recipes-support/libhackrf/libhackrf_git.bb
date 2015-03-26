SUMMARY = "Libhackrf"
HOMEPAGE = "https://github.com/mossmann/hackrf/wiki"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=1484b9683e3fc1dd9f5cf802a23fe67c"

DEPENDS = "libusb"

# Didn't find any version information in the sources
PV = "0.0.1"

inherit cmake pkgconfig

SRC_URI = "git://github.com/mossmann/hackrf.git;branch=master \
          "
S = "${WORKDIR}/git/host"

SRCREV = "50a6622ff8224da4f1aaee91f7c999c017338bb3"
