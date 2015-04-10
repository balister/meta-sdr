require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.8.2.1"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=maint \
          "

SRCREV = "a0d3628a1d954afaa00ebae1bf61ca3bf4fe86d6"

S = "${WORKDIR}/git/host"

