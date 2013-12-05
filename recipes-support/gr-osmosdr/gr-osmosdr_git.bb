require gr-osmosdr.inc

PV = "0.5.1"
PR = "${INC_PR}.0"

SRC_URI = "git://git.osmocom.org/gr-osmosdr;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "81b23e2169e23b8eaf5617026c1f44473a84166c"
