SUMMARY = "Universal Hardware Driver Firmware"
HOMEPAGE = "http://www.ettus.com"

PE = "1"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://share/uhd/images/LICENSE;md5=8255adf1069294c928e0e18b01a16282"

inherit allarch

SRC_URI = "http://files.ettus.com/binaries/images/uhd-images_${PV}-release.zip"
SRC_URI[md5sum] = "37081e1e73004bd9e74d7e5b6293fd39"
SRC_URI[sha256sum] = "5ba67285ffd3e52cf3a7abeef94a5a2bc4cb18c0d5401d07337bfc0aef3ac3ee"

S = "${WORKDIR}/uhd-images_${PV}-release"

do_install() {
    install -d ${D}${datadir}/uhd/images
    install -d ${D}${datadir}/uhd/images/bit
    install -d ${D}${datadir}/uhd/images/winusb_driver
    install -d ${D}${datadir}/uhd/images/winusb_driver/amd64
    install -d ${D}${datadir}/uhd/images/winusb_driver/x86
    install -m 0644 ${S}/share/uhd/images/bit/* ${D}${datadir}/uhd/images/bit
    install -m 0644 ${S}/share/uhd/images/winusb_driver/amd64/* ${D}${datadir}/uhd/images/winusb_driver/amd64
    install -m 0644 ${S}/share/uhd/images/winusb_driver/x86/* ${D}${datadir}/uhd/images/winusb_driver/x86
    install -m 0644 ${S}/share/uhd/images/winusb_driver/*.inf ${D}${datadir}/uhd/images/winusb_driver
    install -m 0644 ${S}/share/uhd/images/*.tag ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/LICENSE ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.hex ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.rbf ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.ihx ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.bin ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.bit ${D}${datadir}/uhd/images
    install -m 0644 ${S}/share/uhd/images/*.lvbitx ${D}${datadir}/uhd/images
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/uhd/images"

