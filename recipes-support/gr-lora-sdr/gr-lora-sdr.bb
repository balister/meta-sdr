SUMMARY = "This is the fully-functional GNU Radio software-defined radio (SDR) implementation of a LoRa transceiver with all the necessary receiver components to operate correctly even at very low SNRs. This work has been conducted at the Telecommunication Circuits Laboratory, EPFL"
HOMEPAGE = "https://github.com/tapparelj/gr-lora_sdr"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=8ad2a0a5a9277845fb953e76de029ec5"

RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot

PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/tapparelj/gr-lora_sdr.git;branch=master;protocol=https \
          "
SRCREV = "b53a3ba434df3150f4fb51a3e4bb1226caa51717"

FILES:${PN} += "${datadir}/gr-lora_sdr/examples/*.grc"

