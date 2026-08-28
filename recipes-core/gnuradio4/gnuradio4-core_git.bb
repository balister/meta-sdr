LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-core.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.0+git"
SRCREV = "e73cbd185ebcec1b11054da4b0e63d11b6fe6abb"

# NOTE: unable to map the following CMake package dependencies: TBB ut httplib Python3
inherit cmake pkgconfig
DEPENDS = "boost-ext-ut vir-simd cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# blocklib_generator builds a code-generator tool (gnuradio_4_0_parse_registrations)
# that must run on the build host during configure/build. Left to its default it
# picks up CMAKE_CXX_COMPILER, which under cross-compilation is the target
# cross-compiler and produces a binary that cannot execute on the host -- point it
# at the host's own g++ (available via HOSTTOOLS) instead.
EXTRA_OECMAKE = "-DENABLE_TESTING=ON -DGNURADIO_PARSE_REGISTRATIONS_TOOL_CXX_COMPLILER=g++ -DGR_DATA_CACHE_DIR=/var/lib/gnuradio4/cache"

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

BBCLASSEXTEND = "native"

