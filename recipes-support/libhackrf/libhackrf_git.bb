SUMMARY = "Libhackrf"
HOMEPAGE = "https://github.com/mossmann/hackrf/wiki"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../COPYING;md5=1484b9683e3fc1dd9f5cf802a23fe67c"

DEPENDS = "libusb fftw"

# Didn't find any version information in the sources
PV = "0.0.2"

inherit cmake pkgconfig

SRC_URI = "git://github.com/mossmann/hackrf.git;branch=master;protocol=https \
          "
S = "${UNPACKDIR}/${BP}/host"

SRCREV = "43e6f99fe8543094d18ff3a6550ed2066c398862"

EXTRA_OECMAKE = "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"

