require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.008.002-release/uhd-${PV}.tar.gz \
           file://fix-flow-control.patch;striplevel=2 \
          "

SRC_URI[md5sum] = "c731e4f5f00cd26de4c41d0eb353e974"
SRC_URI[sha256sum] = "39ae1942c072e5e54e381a8d47249f7a2a9bed6f7b1dfdca531a3aaaf130441c"

S = "${WORKDIR}/${PN}-003.008.002"
