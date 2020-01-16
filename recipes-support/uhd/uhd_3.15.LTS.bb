require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=UHD-3.15.LTS \
           file://0001-Convert-the-asm-s16-le-converters-to-NEON-intrinsics.patch;striplevel=2 \
           file://0002-Be-more-verbose-when-checking-for-python-import.patch \
          "
SRCREV = "aea0e2de34803d5ea8f25d7cf2fb08f4ab9d43f0"
S = "${WORKDIR}/git/host"

EXTRA_OECMAKE_append = " -DUHD_RELEASE_MODE=release"

do_install_append () {
    sed -i "1s@.*@#!/usr/bin/python3@" ${B}/utils/uhd_images_downloader.py
}
