SUMMARY = "This an IEEE 802.11 a/g/p transceiver for GNU Radio that is fitted for operation with Ettus N210s and B210s. Interoperability was tested with many off-the-shelf WiFi cards and IEEE 802.11p prototypes. The code can also be used in simulations."
HOMEPAGE = "https://github.com/gr-ieee80211/gr-ieee802-11"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=0d30d5b085f15eea362471dff2851e51"

DEPENDS = "gr-foo"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot

PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bastibl/gr-ieee802-11;branch=maint-3.10;protocol=https \
          "
SRCREV = "ce7097384bb29f9e73777cf1458a072a90430528"

FILES:${PN} += "${datadir}/gr-ieee802_11/examples/*.grc"

