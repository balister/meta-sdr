SUMMARY = "AirSpy userspace libraries"
HOMEPAGE = "http://airspy.com"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://${S}/src/airspy.c;endline=24;md5=4196d7b9ec30eae9beefa5ea0b7b853e \
    "
DEPENDS = "libusb1"

SRC_URI = "https://github.com/airspy/airspyone_host/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "90decb238bbd81e92671fd9d944b1920"
SRC_URI[sha256sum] = "967ef256596d4527b81f007f77b91caec3e9f5ab148a8fec436a703db85234cc"

S = "${WORKDIR}/airspyone_host-${PV}/libairspy"

inherit pkgconfig cmake

BUGTRACKER = "https://github.com/airspy/airspyone_host/issues"
