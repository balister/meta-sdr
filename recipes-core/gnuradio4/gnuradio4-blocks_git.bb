# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-blocks.git;protocol=https;branch=main \
           file://0001-sdr-the-Soapy-tests-read-their-module-directory-and-.patch \
           file://0002-Atan2-bound-the-tail-copies-by-the-vector-width.patch \
           file://0003-Unary-bound-the-tail-copy-by-the-vector-width.patch \
           file://0004-sdr-a-hardware-run-of-qa_SoapyIntegration-needs-the-.patch \
           file://run-ptest \
           file://gen-graph-tests.py \
           "

# Modify these as desired
PV = "1.0+git"
SRCREV = "4d84d31cdc79669ac6f0aeaca682052097f21f7e"

# NOTE: unable to map the following CMake package dependencies: ut SoapySDR httplib gnuradio4 GnuRadioBlockLib
inherit cmake pkgconfig ptest

# The header-only algorithm library (gnuradio4::gnuradio-algorithm, the
# gnuradio4Library package) used to be the separate gnuradio4-library
# recipe; upstream now builds it in-tree under library/ and installs it
# from here.
DEPENDS = "boost-ext-ut gnuradio4-core cpp-httplib"

# ENABLE_TESTING (default ON upstream) builds the blocks/*/test/qa_* and
# library/algorithm/test/qa_* binaries do_install_ptest stages, as part of the
# ordinary do_compile. Build them only for ptest; the testing blocks and
# headers other recipes' tests use are installed either way.
EXTRA_OECMAKE += "-DENABLE_TESTING=${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'ON', 'OFF', d)}"

# gr_add_graph_test() registers the graph-file tests only when it finds
# rungraph under the core installation, and the recipe-sysroot holds no
# target binaries, so a cross build registers none. Hand it the path rungraph
# has on the target: find_program() does not search when the variable is
# already set. do_install_ptest turns the registered cases into a list
# run-ptest runs.
EXTRA_OECMAKE += "-D_rungraph=${bindir}/rungraph"

# Upstream caps ninja with its own job pools to bound peak memory, and
# ignores PARALLEL_MAKE: compile_pool (GR_BUILD_PARALLEL_LEVEL, default 4)
# for ordinary sources and gr4_heavy_compile (GR_HEAVY_COMPILE_JOBS,
# default 1) for every qa_* test TU. With width 1 the ~200 test TUs
# compile one after another and set the length of do_compile. Size both
# pools from PARALLEL_MAKE instead. Total concurrency is still bounded by
# ninja's -j (PARALLEL_MAKE).
GR4_BLOCKS_JOBS = "${@oe.utils.parallel_make(d) or 1}"
GR4_BLOCKS_HEAVY_JOBS = "${GR4_BLOCKS_JOBS}"
EXTRA_OECMAKE += "-DGR_BUILD_PARALLEL_LEVEL=${GR4_BLOCKS_JOBS} \
                  -DGR_HEAVY_COMPILE_JOBS=${GR4_BLOCKS_HEAVY_JOBS}"

# GR4_ENABLE_SDR (default OFF upstream) gates the find_package(SoapySDR)
# call in CMakeLists.txt, which in turn gates blocks/sdr's `if(TARGET
# SoapySDR)` block (Soapy source/sink blocks, plus qa_Soapy* under
# blocks/sdr/test picked up automatically
# by do_install_ptest's blocks/*/test glob below). Off by default here too,
# to match upstream and avoid silently growing every image's DEPENDS;
# enable with PACKAGECONFIG:append:pn-gnuradio4-blocks = " soapysdr".
#
# qa_SoapySource, qa_SoapyRaiiWrapper and qa_SoapyIntegration read the
# loopback module's directory and an empty SoapySDR root from
# GR_SDR_TEST_SOAPY_MODULE_DIR and GR_SDR_TEST_SOAPY_EMPTY_ROOT (the 0001
# patch; upstream compiles in build-tree paths). run-ptest sets them to where
# do_install_ptest puts soapy_modules and soapy_empty_root.
PACKAGECONFIG ??= ""
PACKAGECONFIG[soapysdr] = "-DGR4_ENABLE_SDR=ON,-DGR4_ENABLE_SDR=OFF,soapysdr"

do_install_ptest() {
    for d in ${B}/blocks/*/test; do
        [ -d "$d" ] || continue
        comp=$(basename $(dirname "$d"))
        install -d ${D}${PTEST_PATH}/blocks/${comp}/test
        for t in ${d}/qa_*; do
            [ -x "$t" ] || continue
            case $(basename ${t}) in
                # qa_apptest_LoadingPlainBlocklibs only finds its plain
                # (non-plugin) block library via a ctest
                # ENVIRONMENT_MODIFICATION property
                # (blocks/libs/test/CMakeLists.txt) that points
                # GNURADIO4_PLUGIN_DIRECTORIES at the build-tree
                # blocks/basic/ directory. We run the binaries directly
                # instead of through ctest, so that variable is never set
                # and the build-tree path wouldn't exist on target anyway.
                qa_apptest_LoadingPlainBlocklibs) continue ;;
            esac
            install -m 0755 ${t} ${D}${PTEST_PATH}/blocks/${comp}/test/
        done
    done
    # The graph-file cases, and the graphs they read (see EXTRA_OECMAKE).
    python3 ${UNPACKDIR}/gen-graph-tests.py ${B} ${S} ${bindir}/rungraph ${D}${PTEST_PATH}
    install -d ${D}${PTEST_PATH}/library/algorithm/test
    install -m 0755 ${B}/library/algorithm/test/qa_* ${D}${PTEST_PATH}/library/algorithm/test/
    # The loopback Soapy module used by the qa_Soapy* tests is only built
    # with GR4_ENABLE_SDR=ON.
    if ${@bb.utils.contains('PACKAGECONFIG', 'soapysdr', 'true', 'false', d)}; then
        install -d ${D}${PTEST_PATH}/blocks/sdr/test/soapy_modules
        install -m 755 ${B}/blocks/sdr/test/soapy_modules/gr-sdr-loopback.so ${D}${PTEST_PATH}/blocks/sdr/test/soapy_modules
        # empty on purpose: the Soapy tests set SOAPY_SDR_ROOT to it so that
        # SoapySDR loads the loopback module alone, not the target's modules.
        install -d ${D}${PTEST_PATH}/blocks/sdr/test/soapy_empty_root
    fi
}

# libGr*Shared.so under plugins/ are runtime-loaded plugin modules
# (PluginLoader.hpp), not link-time-only dev artifacts: they have no
# SONAME/version, so default packaging rules for a nested libdir
# subdirectory don't pick them up. Same pattern as gnuradio4-core.
FILES:${PN} += "${libdir}/gnuradio-4/plugins/*Shared.so"

# The graph-file cases run core's rungraph.
RDEPENDS:${PN}-ptest += "gnuradio4-core"

# The example graphs (blocks/examples) install as data that gr::loadGrc
# reads, outside the default ${datadir}/${BPN}. qa_ExampleGraphs reads them
# from here too (INSTALLED_EXAMPLE_GRAPHS_PATH, set in run-ptest).
FILES:${PN} += "${datadir}/gnuradio-4.0/examples"
FILES:${PN}-staticdev += "${libdir}/gnuradio-4/plugins/*Static.a"

# The block-registration code generator (gnuradio_4_0_parse_registrations)
# bakes the absolute build-time source path into #include lines and comments
# of the .cpp files it generates for each block plugin. Those files end up in
# the debug-source package, so skip the buildpaths QA check there; the
# generated content is functionally identical regardless of build location.
INSANE_SKIP:${PN}-src += "buildpaths"

