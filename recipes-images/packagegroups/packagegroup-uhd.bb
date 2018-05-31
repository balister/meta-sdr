# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-uhd \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-sdr-uhd = "UHD packages."
RDEPENDS_packagegroup-sdr-uhd = "\
    uhd \
    uhd-examples \
"

