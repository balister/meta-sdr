require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.9.1.50"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=rfnoc-devel \
          "

SRCREV = "595ace58474b6617902c8ba434f1caf8a2e7cad8"

S = "${WORKDIR}/git/host"

