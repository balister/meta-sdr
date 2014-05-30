SUMMARY = "Universal Hardware Driver Firmware"
HOMEPAGE = "http://www.ettus.com"

PE = "1"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://share/uhd/images/LICENSE;md5=8255adf1069294c928e0e18b01a16282"

inherit allarch

SRC_URI = "http://files.ettus.com/binaries/uhd_stable/releases/uhd_${PV}-release/uhd-images_${PV}-release.tar.gz"
SRC_URI[md5sum] = "03321be7b175a081b7da0c5b04cad67a"
SRC_URI[sha256sum] = "6c513636380272252ab2e8b3aad8b2f8fab02079caabd7f5b33bb6b07429aae2"

S = "${WORKDIR}/uhd-images_${PV}-release"
B = "${S}"

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

