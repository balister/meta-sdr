LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-core.git;protocol=https;branch=main \
           file://0001-Fix-qa-test-for-case-when-buffer-is-larger-than-requ.patch \
           file://run-ptest \
           "


# Modify these as desired
PV = "1.0+git"
SRCREV = "f7398ba9a437d56c37f1b5348eab5153867b0efb"

# NOTE: unable to map the following CMake package dependencies: TBB ut httplib Python3
inherit cmake pkgconfig ptest
DEPENDS = "boost-ext-ut vir-simd cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# WARNINGS_AS_ERRORS (default ON upstream) bakes -Werror plus a large
# pedantic warning set into the INTERFACE_COMPILE_OPTIONS of the exported
# gnuradio4::gnuradio-options target, which every downstream consumer
# (gnuradio4-blocks, gnuradio4-incubator, gnuradio4-control-plane, ...)
# transitively links against. That means -Werror applies not just to this
# project's own code but to any header a consumer happens to include,
# evaluated against whatever GCC version is in use -- e.g. it turned GCC 16
# false positives inside vendored httplib.h/boost::beast headers into a hard
# build failure for gnuradio4-control-plane. Disable it here so it never
# leaks into consumers' builds.
EXTRA_OECMAKE = "-DENABLE_TESTING=ON -DGR_DATA_CACHE_DIR=/var/lib/gnuradio4/cache -DWARNINGS_AS_ERRORS=OFF"
CXXFLAGS += " -Wno-psabi"

RDEPENDS:${PN}-dev += "vir-simd-dev"

FILES:${PN}-dev += "${libdir}/GnuRadioBlockLib"

# libgnuradio-blocklib-core.so and libgnuradio-plugin.so are runtime-loaded
# plugin modules (PluginLoader.hpp), not link-time-only dev artifacts: they
# have no SONAME/version and are the only artifact (not a symlink to a
# versioned .so), so they belong in the runtime package rather than the
# default -dev catch-all for unversioned .so files (FILES_SOLIBSDEV).
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libgnuradio-blocklib-core.so ${libdir}/libgnuradio-plugin.so"

# config.hpp bakes in the literal build-time compiler path/flags used to build
# this recipe (CXX_COMPILER_PATH/CXX_COMPILER_FLAGS) for the project's runtime
# JIT block-compilation feature; there is no upstream option to avoid this, and
# the recorded cross-compiler path is meaningless on the target anyway unless a
# matching toolchain is deployed there too.
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-staticdev += "buildpaths"

# EXTRA_OECMAKE above already builds the qa_* unit test binaries (part of the
# default ninja "all" target under core/test and meta/test) as a side effect
# of -DENABLE_TESTING=ON, so do_compile_ptest needs no override -- just stage
# the already-built binaries for run-ptest.
do_install_ptest() {
    install -d ${D}${PTEST_PATH}/core/test ${D}${PTEST_PATH}/meta/test

    # qa_SubGraphAssets is excluded: it has TESTS_SOURCE_PATH (the recipe's
    # build-host ${S}/core/test) compiled in to locate its "assets" fixture
    # directory, and it binds a fixed local TCP port to run an embedded HTTP
    # server -- neither works once the binary is relocated onto the target
    # for ptest.
    # qa_PluginBlockLibrary and qa_PluginRegistration are excluded for the
    # same reason: they have TESTS_BINARY_PATH (the recipe's build-host
    # ${B}/core/test) compiled in to locate the plugin .so fixtures that
    # core/test/plugins/CMakeLists.txt builds next to them, and those
    # fixtures are never installed alongside the ptest binaries.
    for t in ${B}/core/test/qa_*; do
        case $(basename ${t}) in
            qa_SubGraphAssets|qa_PluginBlockLibrary|qa_PluginRegistration) continue ;;
        esac
        install -m 0755 ${t} ${D}${PTEST_PATH}/core/test/
    done
    install -m 0755 ${B}/meta/test/qa_* ${D}${PTEST_PATH}/meta/test/
}

BBCLASSEXTEND = "native"

