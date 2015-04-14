require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.8.2.1"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=maint \
          "

SRCREV = "2fe319d9790c7ec0bcdb9582c4fea95f3fd809b9"

S = "${WORKDIR}/git/host"

