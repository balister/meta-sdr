# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-python-extended \
    packagegroup-sdr-gnuradio-base \
    packagegroup-sdr-gnuradio-extended \
    packagegroup-sdr-rtlsdr \
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


SUMMARY_packagegroup-sdr-rtlsdr = "RTLSDR packages."
RDEPENDS_packagegroup-sdr-rtlsdr = "\
    rtl-sdr \
"

SUMMARY_packagegroup-sdr-gnuradio-extended = "All GNU Radio OOT modules."
RDEPENDS_packagegroup-sdr-gnuradio-extended = "\
    gr-framers \
    gr-mac \
    gr-mapper \
    gr-message-tools \
"
