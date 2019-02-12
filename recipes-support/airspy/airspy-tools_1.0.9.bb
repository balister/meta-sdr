SUMMARY = "AirSpy userspace utilities"
HOMEPAGE = "http://airspy.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://${S}/src/airspy_rx.c;endline=21;md5=8643b32b01d99f350264d19401fcd072 \
    "
DEPENDS = "libairspy"

SRC_URI = "https://github.com/airspy/airspyone_host/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "90decb238bbd81e92671fd9d944b1920"
SRC_URI[sha256sum] = "967ef256596d4527b81f007f77b91caec3e9f5ab148a8fec436a703db85234cc"

S = "${WORKDIR}/airspyone_host-${PV}/airspy-tools"

inherit pkgconfig cmake

BUGTRACKER = "https://github.com/airspy/airspyone_host/issues"
