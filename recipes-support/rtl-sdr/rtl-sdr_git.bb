require rtl-sdr.inc

PV = "0.5.1"
PR = "${INC_PR}.0"

SRC_URI = "git://git.osmocom.org/rtl-sdr;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "a42659602deff728da6731928e660f90407bbbe0"
