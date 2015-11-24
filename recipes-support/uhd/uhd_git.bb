require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.9.1.51"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=rfnoc-devel \
          "

SRCREV = "74d178b5c14d1a7c42d6c064423768ad45d545d3"

S = "${WORKDIR}/git/host"

