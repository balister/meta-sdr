SUMMARY = "Libhackrf"
HOMEPAGE = "https://github.com/greatscottgadgets/hackrf"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../COPYING;md5=1484b9683e3fc1dd9f5cf802a23fe67c"

DEPENDS = "libusb fftw"

PV = "2026.01.3+git"

inherit cmake pkgconfig

SRC_URI = "git://github.com/greatscottgadgets/hackrf.git;branch=main;protocol=https \
          "
S = "${UNPACKDIR}/${BP}/host"

SRCREV = "3a63b29953a3b763f428821e02110def9fb1cade"
