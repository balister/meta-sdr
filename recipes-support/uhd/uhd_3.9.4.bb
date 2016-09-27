require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.009.004-release/${PN}-${PV}.tar.gz \
           file://0001-lib-fixed-GCC-6-warnings-errors.patch;striplevel=2 \
           file://0001-Convert-the-asm-s16-le-converters-to-NEON-intrinsics.patch;striplevel=2 \
           file://0001-Fix-lib64-detection-for-cross-builds.patch;striplevel=2 \
          "
SRC_URI[md5sum] = "b9dfa68dc1cbf9d58ab70619d5e459cd"
SRC_URI[sha256sum] = "2835a4fd0ab88caf2e4bca597b7696a2227b47077f865228f0914100a253f2bd"

EXTRA_OECMAKE_append = " -DUHD_RELEASE_MODE=release"
