SUMMARY = "Vendor and platform neutral SDR support library"
HOMEPAGE = "https://github.com/pothosware/SoapySDR/wiki"

LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/pothosware/SoapySDR.git;branch=master;protocol=https"

PV = "0.8.1+git${SRCPV}"
SRCREV = "1551ea0d39ce546b32a15808b9b1241018a89fc8"

inherit cmake pkgconfig

# The SWIG (Python) and LuaJIT bindings under swig/ and luajit/ are already
# self-disabling (find_package(SWIG)/find_package(PythonLibs)/LuaJIT probes)
# when their dependencies aren't found, so nothing needs to be added here to
# keep this a lean core-library-only build.
