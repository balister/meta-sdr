SUMMARY = "Universal Hardware Driver Firmware"
HOMEPAGE = "http://www.ettus.com"

PE = "1"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://share/uhd/images/LICENSE;md5=51b35d652c070d136bf20244494be2d3"

inherit allarch

SRC_URI = "http://files.ettus.com/binaries/uhd_stable/releases/uhd_${PV}-release/uhd-images_${PV}-release.tar.gz"
SRC_URI[md5sum] = "81be16f9195c553f55fc1f5fc0daaddb"
SRC_URI[sha256sum] = "2e04a1ca577b207e1975ae31dce8bc541a0d08d0ca06ce17991e27da7a3a514c"

S = "${WORKDIR}/uhd-images_${PV}-release"

do_install() {
    install -d ${D}${datadir}/uhd/images
    install -d ${D}${datadir}/uhd/images/bit
    install -d ${D}${datadir}/uhd/images/winusb_driver
    install -d ${D}${datadir}/uhd/images/winusb_driver/amd64
    install -d ${D}${datadir}/uhd/images/winusb_driver/x86
    install -m 0644 ${S}/share/uhd/images/bit/* ${D}${datadir}/uhd/images/bit
    rm -rf ${S}/share/uhd/images/bit
    install -m 0644 ${S}/share/uhd/images/winusb_driver/amd64/* ${D}${datadir}/uhd/images/winusb_driver/amd64
    install -m 0644 ${S}/share/uhd/images/winusb_driver/x86/* ${D}${datadir}/uhd/images/winusb_driver/x86
    rm -rf ${S}/share/uhd/images/winusb_driver/amd64
    rm -rf ${S}/share/uhd/images/winusb_driver/x86
    install -m 0644 ${S}/share/uhd/images/winusb_driver/* ${D}${datadir}/uhd/images/winusb_driver
    rm -rf ${S}/share/uhd/images/winusb_driver
    install -m 0644 ${S}/share/uhd/images/* ${D}${datadir}/uhd/images
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/uhd/images"

