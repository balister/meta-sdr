require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=UHD-3.13 \
           file://0001-Convert-the-asm-s16-le-converters-to-NEON-intrinsics.patch;striplevel=2 \
           file://0002-Be-more-verbose-when-checking-for-python-import.patch \
           file://0003-Yet-another-boost-1.67-fix.patch \
          "
SRCREV = "5b23677241b0e974f46297112551469c3f379e1e"
S = "${WORKDIR}/git/host"

EXTRA_OECMAKE_append = " -DUHD_RELEASE_MODE=release"
