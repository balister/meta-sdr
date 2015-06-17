require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.8.4.50"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=rfnoc-devel \
          "

SRCREV = "b15afd6085d2811d0417f13e6ff824fc6c7361e0"

S = "${WORKDIR}/git/host"

