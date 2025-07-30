DESCRIPTION = "Program to decode radio transmissions from devices on the ISM bands (and other frequencies)"
HOMEPAGE = "https://github.com/merbanan/rtl_433/"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PV = "25.02"
SRCREV = "5cae16fbc9c1c98652676ab45d7bbf7f51e6ccea"
SRC_URI = "git://github.com/merbanan/rtl_433.git;protocol=https;branch=master"

DEPENDS = "libusb1 rtl-sdr openssl"

inherit cmake

EXTRA_OECMAKE = "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"

