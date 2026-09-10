# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-blocks.git;protocol=https;branch=main \
           file://run-ptest \
           "

# Modify these as desired
PV = "1.0+git"
SRCREV = "68702fddbb0ed6749701c3e29487ed8d9a05144d"

# NOTE: unable to map the following CMake package dependencies: ut gnuradio4Library SoapySDR httplib gnuradio4 GnuRadioBlockLib
inherit cmake pkgconfig ptest

DEPENDS = "boost-ext-ut gnuradio4-library cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# ENABLE_TESTING defaults to ON upstream, so the blocks/*/test/qa_* binaries
# below are already built by the ordinary do_compile as a side effect --
# nothing to add here.
EXTRA_OECMAKE = ""

# GR4_ENABLE_SDR (default OFF upstream) gates the find_package(SoapySDR)
# call in CMakeLists.txt, which in turn gates blocks/sdr's `if(TARGET
# SoapySDR)` block (RTL2832 + Soapy source/sink blocks, plus
# qa_RTL2832Source/qa_Soapy* under blocks/sdr/test picked up automatically
# by do_install_ptest's blocks/*/test glob below). Off by default here too,
# to match upstream and avoid silently growing every image's DEPENDS;
# enable with PACKAGECONFIG:append:pn-gnuradio4-blocks = " soapysdr".
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
}

# libGr*Shared.so under plugins/ are runtime-loaded plugin modules
# (PluginLoader.hpp), not link-time-only dev artifacts: they have no
# SONAME/version, so default packaging rules for a nested libdir
# subdirectory don't pick them up. Same pattern as gnuradio4-core.
FILES:${PN} += "${libdir}/gnuradio-4/plugins/*Shared.so"
FILES:${PN}-staticdev += "${libdir}/gnuradio-4/plugins/*Static.a"

# The block-registration code generator (gnuradio_4_0_parse_registrations)
# bakes the absolute build-time source path into #include lines and comments
# of the .cpp files it generates for each block plugin. Those files end up in
# the debug-source package, so skip the buildpaths QA check there; the
# generated content is functionally identical regardless of build location.
INSANE_SKIP:${PN}-src += "buildpaths"

