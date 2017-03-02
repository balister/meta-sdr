# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-python-extended \
    packagegroup-sdr-gnuradio-base \
    packagegroup-sdr-gnuradio-extended \
    packagegroup-sdr-hardware \
    packagegroup-sdr-uhd \
    packagegroup-sdr-rtlsdr \
    packagegroup-sdr-bladerf \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-sdr-python-extended = "Useful python packages."
RDEPENDS_packagegroup-sdr-python-extended = "\
    python-argparse \
    python-cython \
    python-numpy \
    python-modules \
    python-six \
    python-twisted \
"

SUMMARY_packagegroup-sdr-gnuradio-base = "Basic GNU Radio install."
RDEPENDS_packagegroup-sdr-gnuradio-base = "\
    gnuradio \
    gr-osmosdr \
"


SUMMARY_packagegroup-sdr-uhd = "UHD packages."
RDEPENDS_packagegroup-sdr-uhd = "\
    uhd \
    uhd-examples \
"

SUMMARY_packagegroup-sdr-rtlsdr = "RTLSDR packages."
RDEPENDS_packagegroup-sdr-rtlsdr = "\
    rtl-sdr \
"

SUMMARY_packagegroup-sdr-bladerf = "BladeRF packages."
RDEPENDS_packagegroup-sdr-bladerf = "\
    libbladerf \
    libbladerf-bin \
"

SUMMARY_packagegroup-sdr-hardware = "All supported SDR hardware."
RDEPENDS_packagegroup-sdr-hardware = "\
    packagegroup-sdr-uhd \
    packagegroup-sdr-rtlsdr \
    packagegroup-sdr-bladerf \
"

SUMMARY_packagegroup-sdr-gnuradio-extended = "All GNU Radio OOT modules."
RDEPENDS_packagegroup-sdr-gnuradio-extended = "\
    gr-framers \
    gr-mac \
    gr-mapper \
    gr-message-tools \
"
