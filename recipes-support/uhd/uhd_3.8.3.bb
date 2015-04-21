require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.008.003-release/uhd-${PV}.tar.gz \
          "

SRC_URI[md5sum] = "84928825717678e77ffc400d73bcf412"
SRC_URI[sha256sum] = "8ae00c4cc746896570bfcefb985180e6006aa8cba5980030526fd40b86458787"

S = "${WORKDIR}/${PN}-${PV}"
