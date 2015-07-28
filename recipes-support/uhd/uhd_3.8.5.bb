require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"


PV = "3.8.5.1"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.008.005-release/uhd-${PV}.tar.gz \
           file://stupid.patch;pnum=2 \
          "
SRC_URI[md5sum] = "e36365c2a67bdcca546bf9517f59bf7a"
SRC_URI[sha256sum] = "a10544a54503e2494a431ca359d61b046087eb23e515a4dbbc57ad4c50ff3a0e"

S = "${WORKDIR}/${PN}-${PV}"
