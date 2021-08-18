# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-uhd \
"

PROVIDES = "${PACKAGES}"

SUMMARY:packagegroup-sdr-uhd = "UHD packages."
RDEPENDS:packagegroup-sdr-uhd = "\
    uhd \
    uhd-examples \
"

