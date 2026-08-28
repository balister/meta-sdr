# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; they have been separated with AND
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with OR
# instead of AND. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPL-3.0-only AND MIT"
LIC_FILES_CHKSUM = "file://blocks/analog/LICENSE;md5=8ea682db15fffa46d31a4badd40a709b \
                    file://blocks/basic/LICENSE;md5=8ea682db15fffa46d31a4badd40a709b \
                    file://blocks/channel/LICENSE;md5=8ea682db15fffa46d31a4badd40a709b \
                    file://blocks/measure/LICENSE;md5=8ea682db15fffa46d31a4badd40a709b \
                    file://blocks/pfb/LICENSE;md5=d32239bcb673463ab874e80d47fae504 \
                    file://blocks/zeromq/LICENSE;md5=8ea682db15fffa46d31a4badd40a709b"

SRC_URI = "git://github.com/gnuradio/gr4-incubator.git;protocol=https;branch=main \
           file://0001-blocks-filter-skip-broken-qa_FirDecimator-test.patch"

# Modify these as desired
PV = "1.0+git"
SRCREV = "dd31b1ade39b74d5703d04d94c4cc196a86a44b0"

# cmake/Dependencies.cmake in this repo pulls in imgui/implot/glfw3/OpenGL,
# SoapySDR, rtaudio and CLI11 only when ENABLE_EXAMPLES is on -- and
# ENABLE_EXAMPLES defaults ON upstream. SoapySDR and rtaudio have no recipe
# anywhere in this build, so examples are disabled below rather than adding
# them; only algorithm/blocks/schedulers libraries and the test suite
# (ENABLE_TESTING, left at its upstream default of ON) are built.
# blocks/zeromq/test/qa_ZmqBlocks.cpp includes
# <gnuradio-4.0/testing/NullSources.hpp> straight off the default system
# include path (no pkg-config/find_package for it), so gnuradio4-blocks-dev's
# headers must be present in this recipe's sysroot.
DEPENDS = "gnuradio4-core gnuradio4-blocks boost-ext-ut cpp-httplib cppzmq nlohmann-json zlib openssl"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DENABLE_EXAMPLES=OFF"

# algorithm/CMakeLists.txt builds pmt_converter as a SHARED library without
# setting VERSION/SOVERSION, so it has no SONAME and no symlink chain -- just
# a bare .so, which default packaging treats as -dev-only link-time material.
# It's a real runtime dependency of the blocks that link against it, so ship
# it in the main package instead, same as gnuradio4-core's unversioned
# runtime-loaded plugin libs.
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libpmt_converter.so"

