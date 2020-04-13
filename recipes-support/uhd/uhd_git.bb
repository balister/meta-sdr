require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

PV = "3.14.1.1"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=UHD-3.14.L \
          "

SRCREV = "7c0291adae76e026733cf1939f5920c9fe64967b"

S = "${WORKDIR}/git/host"

do_install_prepend () {
    sed -i "1s@.*@#!/usr/bin/python@" ${B}/utils/uhd_images_downloader.py
}
