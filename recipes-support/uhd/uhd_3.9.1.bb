require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.9.1"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.009.001-release/uhd-3.9.1.tar.gz" 
SRC_URI[md5sum] = "d5165d692aaffbd6905e3f4ad16d0f1d"
SRC_URI[sha256sum] = "f4f2ba94fecc36953cc0c16a5c3f118c80e376f8e2a4ce39cd51abdb9ead452f"

S = "${WORKDIR}/${PN}-3.9.1"
