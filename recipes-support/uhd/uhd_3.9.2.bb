require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.009.002-release/${PN}-${PV}.tar.gz \
           file://0001-Unroll-the-loops-in-the-NEON-float-to-from-integer-c.patch;striplevel=2 \
          "
SRC_URI[md5sum] = "fdc9628e3057575829a47855398954e4"
SRC_URI[sha256sum] = "150f4d189dde284b08ef35f313932b94120f8cba5eaf9afaa1bb231ef4374497"
