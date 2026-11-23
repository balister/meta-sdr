LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-core.git;protocol=https;branch=main \
           file://0001-Fix-qa-test-for-case-when-buffer-is-larger-than-requ.patch \
           file://0002-qa_SchedulerLifecycle-build-without-the-cross-object.patch \
           file://run-ptest \
           "


# Modify these as desired
PV = "1.0+git"
SRCREV = "46debd39b1edf6d22c3d2689ebc11e2df2995865"

# NOTE: unable to map the following CMake package dependencies: TBB ut httplib Python3
inherit cmake pkgconfig ptest
DEPENDS = "boost-ext-ut vir-simd cpp-httplib"

# WARNINGS_AS_ERRORS (default ON upstream) adds -Werror to this project's
# own build only; upstream keeps its warning flags out of the installed
# gnuradio4::gnuradio-options target. Turn it off so a new compiler's
# warnings don't fail the build.
# Build the qa_* tests only for ptest.
EXTRA_OECMAKE = "-DENABLE_TESTING=${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'ON', 'OFF', d)} -DWARNINGS_AS_ERRORS=OFF"

# Upstream caps ninja with its own compile_pool (GR_BUILD_PARALLEL_LEVEL,
# default 6) to bound peak memory, and ignores PARALLEL_MAKE. Size it from
# PARALLEL_MAKE instead, as gnuradio4-blocks does.
EXTRA_OECMAKE += "-DGR_BUILD_PARALLEL_LEVEL=${@oe.utils.parallel_make(d) or 1}"

# gr::kCacheLine falls back to std::hardware_destructive_interference_size,
# which GCC reports as 32 on riscv64. The default allocator then only gives
# 32-byte alignment, but the FFT code and qa_MemoryAllocators/qa_buffer
# require 64 (and the U54 cores have 64-byte cache lines). The value is
# exported as an INTERFACE define to consumers of the CMake package, and in
# gnuradio4.pc's Cflags for pkg-config consumers (gnuradio4-studio-blocks).
EXTRA_OECMAKE:append:riscv64 = " -DGR_CACHE_LINE_SIZE=64"

CXXFLAGS += " -Wno-psabi"

# With full -g, qa_SchedulerLifecycle.cpp crashes the riscv64 assembler, or
# fails to link with "dangerous relocation: Mismatched R_RISCV_SET_ULEB128"
# in .debug_loclists (binutils 2.47, gcc 16.2). Use reduced debug info there.
DEBUG_LEVELFLAG:riscv64 = "-g1"

RDEPENDS:${PN}-dev += "vir-simd-dev"

FILES:${PN}-dev += "${libdir}/GnuRadioBlockLib"

# libgnuradio-blocklib-core.so and libgnuradio-plugin.so are runtime-loaded
# plugin modules (PluginLoader.hpp), not link-time-only dev artifacts: they
# have no SONAME/version and are the only artifact (not a symlink to a
# versioned .so), so they belong in the runtime package rather than the
# default -dev catch-all for unversioned .so files (FILES_SOLIBSDEV).
# libgnuradio-shared-state.so is likewise unversioned (its SONAME is the bare
# .so name), but it is a regular link-time library: consumers record it in
# DT_NEEDED, so it too must ship in the runtime package.
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libgnuradio-blocklib-core.so ${libdir}/libgnuradio-plugin.so \
                ${libdir}/libgnuradio-shared-state.so"

# config.hpp bakes in the literal build-time compiler path/flags used to build
# this recipe (CXX_COMPILER_PATH/CXX_COMPILER_FLAGS) for the project's runtime
# JIT block-compilation feature; there is no upstream option to avoid this, and
# the recorded cross-compiler path is meaningless on the target anyway unless a
# matching toolchain is deployed there too.
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-staticdev += "buildpaths"

# The core/test/plugins fixtures installed for qa_PluginGlobalDefault are
# built from .cpp files the block-registration code generator writes with
# the absolute build-time source path in #include lines and comments; those
# end up in the debug-source package (same as gnuradio4-blocks).
INSANE_SKIP:${PN}-src += "buildpaths"

# EXTRA_OECMAKE above already builds the qa_* unit test binaries (part of the
# default ninja "all" target under core/test and meta/test) as a side effect
# of ENABLE_TESTING, so do_compile_ptest needs no override -- just stage
# the already-built binaries for run-ptest.
do_install_ptest() {
    install -d ${D}${PTEST_PATH}/core/test ${D}${PTEST_PATH}/meta/test

    # qa_SubGraphAssets is excluded: it has TESTS_SOURCE_PATH (the recipe's
    # build-host ${S}/core/test) compiled in to locate its "assets" fixture
    # directory, and it binds a fixed local TCP port to run an embedded HTTP
    # server -- neither works once the binary is relocated onto the target
    # for ptest.
    # qa_PluginBlockLibrary, qa_PluginRegistration and qa_PluginAbiVersion
    # are excluded for the same reason: they have TESTS_BINARY_PATH (the
    # recipe's build-host ${B}/core/test) compiled in to locate the plugin
    # .so fixtures that core/test/plugins/CMakeLists.txt builds next to
    # them, and those fixtures are never installed alongside the ptest
    # binaries. qa_SharedObjectState is excluded for the same reason: every
    # case loads the cross_object_library fixture from TESTS_BINARY_PATH.
    # qa_DeviceListing and qa_ErasedRuntime load plugin fixtures from
    # TESTS_BINARY_PATH too.
    # (qa_SchedulerLifecycle's cases that need that fixture are compiled out
    # by 0002-qa_SchedulerLifecycle-build-without-the-cross-object.patch.)
    for t in ${B}/core/test/qa_*; do
        case $(basename ${t}) in
            qa_SubGraphAssets|qa_PluginBlockLibrary|qa_PluginRegistration|qa_PluginAbiVersion|qa_SharedObjectState| \
            qa_DeviceListing|qa_ErasedRuntime) continue ;;
        esac
        install -m 0755 ${t} ${D}${PTEST_PATH}/core/test/
    done

    # qa_PluginGlobalDefault loads the core/test/plugins fixtures from
    # ../plugins, relative to the empty directory ctest runs it in
    # (global_default_cwd); run-ptest runs it there the same way.
    install -d ${D}${PTEST_PATH}/core/test/plugins ${D}${PTEST_PATH}/core/test/global_default_cwd
    install -m 0755 ${B}/core/test/plugins/lib*.so ${D}${PTEST_PATH}/core/test/plugins/
    install -m 0755 ${B}/meta/test/qa_* ${D}${PTEST_PATH}/meta/test/
}

BBCLASSEXTEND = "native"

