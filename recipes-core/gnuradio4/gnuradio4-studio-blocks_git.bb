SUMMARY = "GNU Radio 4 blocks for gr4-studio (Studio-compatible sinks)"
HOMEPAGE = "https://github.com/gnuradio/gnuradio4-studio"

# The blocks/ subdirectory is its own standalone CMake project with its own
# MIT LICENSE, distinct from the rest of gnuradio4-studio (GPL-3.0-or-later).
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dca174369926f2d6038aaf9ee5698d26"

# subpath=blocks sparse-checks-out just this subdirectory; its default
# destsuffix ("blocks/", the subpath's basename) doesn't match the recipe's
# default S (${UNPACKDIR}/${BP}), so S is set explicitly below.
SRC_URI = "git://github.com/gnuradio/gnuradio4-studio.git;protocol=https;branch=main;subpath=blocks \
           file://run-ptest \
           "

PV = "0.1.0+git"
SRCREV = "006923a25f031e7c7cbae634ecaca4c5c75e3280"

S = "${UNPACKDIR}/blocks"

inherit cmake pkgconfig ptest

# None of these appear in blocks/studio's own CMakeLists.txt DEPENDS, but the
# headers/tests need them directly:
#  - boost (boost::beast, header-only) for StudioWebSocketTransport.hpp's
#    websocket transport support.
#  - gnuradio4-library for StudioPowerSpectrumSink.hpp's
#    <gnuradio-4.0/algorithm/fourier/fft.hpp> (the header-only algorithm
#    library gnuradio4-core itself doesn't provide).
#  - gnuradio4-blocks for the qa_* tests' <gnuradio-4.0/testing/NullSources.hpp>,
#    which they include straight off the default system include path (same
#    issue as gnuradio4-incubator's qa_ZmqBlocks.cpp).
DEPENDS = "gnuradio4-core gnuradio4-library gnuradio4-blocks cpp-httplib openssl boost"

# ENABLE_TESTING is this project's own (non-standard) gate for its test/
# subdirectory; it defaults OFF (no CTest/BUILD_TESTING here), matching the
# other gnuradio4-* recipes' EXTRA_OECMAKE convention. Turning it on builds
# the qa_* binaries (blocks/studio/test) that do_install_ptest below stages.
EXTRA_OECMAKE = "-DENABLE_TESTING=ON"

# EXTRA_OECMAKE above already builds the qa_* test binaries (part of the
# default ninja "all" target as a side effect of -DENABLE_TESTING=ON), so
# do_compile_ptest needs no override -- just stage them for run-ptest.
do_install_ptest() {
    install -d ${D}${PTEST_PATH}/studio/test
    install -m 0755 ${B}/studio/test/qa_* ${D}${PTEST_PATH}/studio/test/
}

# Gr4StudioBlocksPlugin is a runtime-loaded plugin module
# (PluginLoader.hpp), not a link-time-only dev artifact: it has no
# SONAME/version, so default packaging rules for an unversioned .so would
# otherwise claim it into the -dev package. Same pattern as gnuradio4-core
# and gnuradio4-blocks.
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libGr4StudioBlocksPlugin.so"

# The block-registration code generator (gnuradio_4_0_parse_registrations)
# bakes the absolute build-time source path into #include lines and comments
# of the .cpp files it generates for each block plugin. Those files end up in
# the debug-source package, so skip the buildpaths QA check there; the
# generated content is functionally identical regardless of build location.
# Same issue as gnuradio4-blocks (same generator).
INSANE_SKIP:${PN}-src += "buildpaths"
