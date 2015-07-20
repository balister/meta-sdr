require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.8.4.50"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=rfnoc-devel \
          "

SRCREV = "4e013edefb2dd1799d55d722cb5d0d4e4f0d6425"

S = "${WORKDIR}/git/host"

