LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-core.git;protocol=https;branch=main \
           file://0002-bench-do-not-use-march-native-when-cross-compiling.patch \
           file://run-ptest \
           "


# Modify these as desired
PV = "1.0+git"
SRCREV = "657ef622258b77d2b6a9e432f24de103e809434b"

# NOTE: unable to map the following CMake package dependencies: TBB ut httplib Python3
inherit cmake pkgconfig ptest
DEPENDS = "boost-ext-ut vir-simd cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# blocklib_generator builds a code-generator tool (gnuradio_4_0_parse_registrations)
# that must run on the build host during configure/build. Left to its default it
# picks up CMAKE_CXX_COMPILER, which under cross-compilation is the target
# cross-compiler and produces a binary that cannot execute on the host -- point it
# at the host's own g++ (available via HOSTTOOLS) instead.
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
EXTRA_OECMAKE = "-DENABLE_TESTING=ON -DGNURADIO_PARSE_REGISTRATIONS_TOOL_CXX_COMPLILER=g++ -DGR_DATA_CACHE_DIR=/var/lib/gnuradio4/cache -DWARNINGS_AS_ERRORS=OFF"
CXXFLAGS += " -Wno-psabi"

# gnuradio_4_0_parse_registrations (installed to bindir above) is invoked at
# configure time by downstream recipes (e.g. gnuradio4-blocks) via the path
# GnuRadioBlockLibConfig.cmake computes from its own install prefix. bindir is
# not part of the default SYSROOT_DIRS for a non-native recipe, so without
# this the tool never reaches consumers' recipe-sysroot and configure fails
# looking for it. It's the only thing this recipe installs to bindir, and
# it's already forced to build as a host-native binary above, so staging all
# of bindir is safe.
SYSROOT_DIRS:append = " ${bindir}"

# gnuradio_4_0_parse_registrations is a host-native ELF (see comment above), so
# the target strip tool (aarch64-oe-linux-strip here) cannot recognise its
# architecture. do_package strips everything under PKGD regardless of FILES
# assignment, and do_populate_sysroot has no per-file exemption, so skip both.
INHIBIT_PACKAGE_STRIP_FILES = "${PKGD}${bindir}/gnuradio_4_0_parse_registrations"
INHIBIT_SYSROOT_STRIP = "1"

# The default FILES:${PN} = "${bindir}/* ..." glob (bitbake.conf) sweeps this
# host-native binary into the target package too -- it is otherwise harmless
# there (wrong-arch ELF the target just can't execute), but do_package_qa
# flags it as an architecture mismatch and as missing RDEPENDS for the glibc
# it was linked against on the host. Both are expected for a host tool.
INSANE_SKIP:${PN} += "arch file-rdeps"

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
    for t in ${B}/core/test/qa_*; do
        case $(basename ${t}) in
            qa_SubGraphAssets) continue ;;
        esac
        install -m 0755 ${t} ${D}${PTEST_PATH}/core/test/
    done
    install -m 0755 ${B}/meta/test/qa_* ${D}${PTEST_PATH}/meta/test/
}

BBCLASSEXTEND = "native"

