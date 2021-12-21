# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-python-extended \
    packagegroup-sdr-gnuradio-base \
    packagegroup-sdr-gnuradio-extended \
    packagegroup-sdr-rtlsdr \
"

PROVIDES = "${PACKAGES}"

SUMMARY:packagegroup-sdr-python-extended = "Useful python packages."
RDEPENDS:packagegroup-sdr-python-extended = "\
    python3-cython \
    python3-numpy \
    python3-modules \
    python3-six \
    python3-twisted \
"

SUMMARY:packagegroup-sdr-gnuradio-base = "Basic GNU Radio install."
RDEPENDS:packagegroup-sdr-gnuradio-base = "\
    gnuradio \
"


SUMMARY:packagegroup-sdr-rtlsdr = "RTLSDR packages."
RDEPENDS:packagegroup-sdr-rtlsdr = "\
    rtl-sdr \
"

