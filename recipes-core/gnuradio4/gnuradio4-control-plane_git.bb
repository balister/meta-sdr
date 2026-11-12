# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9547a0c375a0c21052f9ea55d9b4c604"

SRC_URI = "git://github.com/gnuradio/gnuradio4-control-plane.git;protocol=https;branch=main \
           file://run-ptest \
           "

# Modify these as desired
PV = "1.0+git"
SRCREV = "d599f08013d0249d765cd43c7b945717ce2223bb"

DEPENDS = "zlib boost gnuradio4-core cpp-httplib nlohmann-json googletest"

inherit cmake pkgconfig ptest

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
# gtest_discover_tests() runs each test binary at build time to list its
# cases, which can't work for target binaries. PRE_TEST defers that to ctest,
# which this recipe never runs (run-ptest runs the binaries directly).
EXTRA_OECMAKE = "-DCMAKE_GTEST_DISCOVER_TESTS_DISCOVERY_MODE=PRE_TEST"

# The gr4cp_*_test gtest binaries are already built by the ordinary
# do_compile (not gated behind any CMake option), so no do_compile_ptest
# override is needed -- just stage them, and the plugin gr4cp_core_test
# loads, for run-ptest.
do_install_ptest() {
    install -d ${D}${PTEST_PATH}
    for t in gr4cp_smoke_test gr4cp_core_test gr4cp_http_test gr4cp_wasm_api_test gr4cp_cli_test; do
        install -m 0755 ${B}/${t} ${D}${PTEST_PATH}/
    done
    install -m 0755 ${B}/libgr4cp_broken_plugin.so ${D}${PTEST_PATH}/
}

