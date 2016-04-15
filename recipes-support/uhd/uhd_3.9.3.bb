require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.009.003-release/${PN}-${PV}.tar.gz \
           file://0001-Unroll-the-loops-in-the-NEON-float-to-from-integer-c.patch;striplevel=2 \
          "
SRC_URI[md5sum] = "4f423e3b780b8d5a47d538cc84d05f54"
SRC_URI[sha256sum] = "bcbff142e642913528f21864cab13832b7866f82ab976b7435d88613aaa69451"

