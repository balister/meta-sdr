# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-library.git;protocol=https;branch=main \
           file://0001-algorithm-benchmarks-do-not-use-march-native-when-cr.patch \
           file://run-ptest \
           "

# Modify these as desired
PV = "1.0+git"
SRCREV = "d60e12f8575a571da045ca4a20ba12344b094ba3"

# NOTE: unable to map the following CMake package dependencies: gnuradio4 ut httplib
inherit cmake pkgconfig ptest

DEPENDS = "gnuradio4-core boost-ext-ut cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# ENABLE_TESTING defaults to ON upstream, so the algorithm/test/qa_* binaries
# below are already built by the ordinary do_compile -- nothing to add here.
EXTRA_OECMAKE = ""

# gnuradio-algorithm is a header-only (CMake INTERFACE) library: ${PN} ships
# no runtime files and is never produced as a package (see the empty
# packages-split/gnuradio4-library directory), so ptest.bbclass's default
# RDEPENDS:${PN}-ptest += "${PN}" would point at a package that doesn't
# exist. Drop it; the real runtime deps of the qa_* test binaries (libssl,
# libcrypto, libz pulled in by qa_FileIo's httplib use) are still picked up
# automatically by the normal shlibs dependency scan.
RDEPENDS:${PN}-ptest = ""

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/algorithm/test
    install -m 0755 ${B}/algorithm/test/qa_* ${D}${PTEST_PATH}/algorithm/test/
}

