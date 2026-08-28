# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1321bdf796c67e3a8ab8e352dd81474b"

SRC_URI = "git://github.com/yhirose/cpp-httplib.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "8829fac98e615f52a880bf758573806b39af9d9d"

# NOTE: unable to map the following CMake package dependencies: Python3 Brotli zstd GTest wolfssl MbedTLS
DEPENDS = "curl openssl zlib"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

BBCLASSEXTEND = "native"

do_install:append() {
    rm -rf ${D}${datadir}/licenses
}
