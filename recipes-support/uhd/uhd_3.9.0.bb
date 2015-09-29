require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.9.0"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.009.000-release/uhd-3.9.0.tar.gz \
          "
SRC_URI[md5sum] = "2b38eea8a5e7d011c0565e54d2cb1d97"
SRC_URI[sha256sum] = "04b650ef44a7c442f11e2bfcccc19c5bf3c678006fc681a56e378b27d1009c1d"

S = "${WORKDIR}/${PN}-3.9.0"
