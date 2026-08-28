# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9547a0c375a0c21052f9ea55d9b4c604"

SRC_URI = "git://github.com/gnuradio/gnuradio4-control-plane.git;protocol=https;branch=main \
           file://0001-defer-gtest-discovery-to-test-time.patch \
           file://0002-allow-overriding-gnuradio4-lib-dir.patch"

# Modify these as desired
PV = "1.0+git"
SRCREV = "b2c04abddd1fb792cc8c7db880050adb0213afb6"

DEPENDS = "zlib boost gnuradio4-core cpp-httplib nlohmann-json googletest"

inherit cmake pkgconfig

# gnuradio4's exported gnuradio4::gnuradio-options target used to carry
# -Werror in its INTERFACE_COMPILE_OPTIONS, which propagated to any consumer
# linking against it -- including this recipe's test binaries, turning GCC 16
# false positives (-Warray-bounds/-Wnull-dereference) inside vendored
# httplib.h and boost::beast headers into hard errors. Fixed at the source by
# building gnuradio4-core with -DWARNINGS_AS_ERRORS=OFF (see that recipe);
# this project's own GR4CP_SUPPRESS_IMPORTED_WERROR option doesn't apply here
# since it only strips gnuradio-core/gnuradio-blocklib-core, not the actual
# gnuradio-options target that carried the flag.
#
# GR4CP_GNURADIO4_LIB_DIR (see 0002 patch) is derived by upstream from where
# gnuradio4Config.cmake was found, i.e. this recipe's own recipe-sysroot --
# baking a nonexistent build-host path into gr4cp_server/libgr4cp_core.a as
# the runtime plugin search dir. Point it at the real target install path.
EXTRA_OECMAKE = "-DGR4CP_GNURADIO4_LIB_DIR=${libdir}"

