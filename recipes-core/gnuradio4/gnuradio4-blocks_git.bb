# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2d3fb84bc5ba2e8e9f06a3100f1e458"

SRC_URI = "git://github.com/gnuradio/gnuradio4-blocks.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.0+git"
SRCREV = "68702fddbb0ed6749701c3e29487ed8d9a05144d"

# NOTE: unable to map the following CMake package dependencies: ut gnuradio4Library SoapySDR httplib gnuradio4 GnuRadioBlockLib
inherit cmake pkgconfig

DEPENDS = "boost-ext-ut gnuradio4-library cpp-httplib"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

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

