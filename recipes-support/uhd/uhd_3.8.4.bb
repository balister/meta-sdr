require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.008.004-release/uhd-3.8.4.tar.gz \
           file://Fix_E310_GPS_again.patch;striplevel=2 \
          "

SRC_URI[md5sum] = "7103a10710d6a043e4b910b621c7c9e7"
SRC_URI[sha256sum] = "08ef531c3b6e71129e6511e1929476abc1f7d505f8663054b0f6ef42e90d8109"

S = "${WORKDIR}/${PN}-3.8.4"

PV = "3.8.4.1"
