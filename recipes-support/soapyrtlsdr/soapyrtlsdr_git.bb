SUMMARY = "SoapySDR RTL-SDR Support Module"
HOMEPAGE = "https://github.com/pothosware/SoapyRTLSDR/wiki"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=76c8dd204c0791e9a30c30d0406b75da"

SRC_URI = "git://github.com/pothosware/SoapyRTLSDR.git;branch=master;protocol=https"

PV = "0.3.0+git${SRCPV}"
SRCREV = "b1f568d1b57cc973a1d2ee49be68d0d748d164e4"

DEPENDS = "soapysdr rtl-sdr"

inherit cmake pkgconfig

# SOAPY_SDR_MODULE_UTIL() installs the plugin as an unversioned,
# runtime-dlopen()'d .so under ${libdir}/SoapySDR/modules<ABI>/, so it
# belongs in the main package rather than -dev/-staticdev (same pattern
# as gnuradio4-core's PluginLoader modules).
FILES:${PN} += "${libdir}/SoapySDR"
FILES_SOLIBSDEV = ""
