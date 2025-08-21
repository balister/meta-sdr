DESCRIPTION = "Program to decode radio transmissions from devices on the ISM bands (and other frequencies)"
HOMEPAGE = "https://github.com/merbanan/rtl_433/"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PV = "25.02+git"
SRCREV = "8bfb77b5c3368c1136aa39157c6be25bd6fc8e96"
SRC_URI = "git://github.com/merbanan/rtl_433.git;protocol=https;branch=master"

DEPENDS = "libusb1 rtl-sdr openssl"

inherit cmake

