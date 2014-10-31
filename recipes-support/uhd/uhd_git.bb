require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.7.1"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=master \
           file://0001-Do-not-set-the-mfloat-soft-flag-during-the-test-for-.patch;pnum=2 \
"

SRCREV = "8f46b048818ba107126910159c76453cfb2025e2"

S = "${WORKDIR}/git/host"

