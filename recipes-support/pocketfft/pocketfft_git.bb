SUMMARY = "Header-only C++ FFT library"
DESCRIPTION = "pocketfft is a heavily modified implementation of FFTPack, \
with support for multidimensional arrays, single/double/long double \
precision, real and complex transforms, and DCT/DST."
HOMEPAGE = "https://github.com/mreineck/pocketfft"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=bb0e49a83ba802d32f3a05a7b8b2180b"

SRC_URI = "git://github.com/mreineck/pocketfft.git;protocol=https;branch=cpp"

PV = "0.1.0+git"
SRCREV = "4d865cba24359b05b37da4e75aee24498c3b78e7"

# Header only: nothing to configure or compile.
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 0644 ${S}/pocketfft_hdronly.h ${D}${includedir}/
}

ALLOW_EMPTY:${PN} = "1"

BBCLASSEXTEND = "native nativesdk"
