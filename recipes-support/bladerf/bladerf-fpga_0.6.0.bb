SUMMARY = "Pre-built FPGA bitstreams for the Nuand bladeRF"
HOMEPAGE = "http://www.nuand.com"
BUGTRACKER = "https://github.com/nuand/bladeRF/issues"

# The Nuand HDL is MIT-licensed, so we'll point to the matching portions of
# the license text from the common license directory, as to not require
# checking out an entire codebase just for the license file.
#
# The original license text is available at:
#   https://raw.githubusercontent.com/Nuand/bladeRF/master/legal/licenses/LICENSE.MIT.nuand
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;beginline=6;endline=22;md5=838c366f69b72c5df05c96dff79b35f2"

SRC_URI = "http://www.nuand.com/fpga/v${PV}/hostedx40.rbf;name=x40 \
           http://www.nuand.com/fpga/v${PV}/hostedx115.rbf;name=x115 "

SRC_URI[x40.md5sum] = "29a65d08e3a98f16dd26dee5bc9200a1"
SRC_URI[x40.sha256sum] = "4d3a2f8adb459b67391aa0a6225461df2fbb8e3fb2ae7589b9dd22c8c1b0041b"

SRC_URI[x115.md5sum] = "326dc7f8e87b6f38716470b43de8b4e2"
SRC_URI[x115.sha256sum] = "57d57f11e85c9727f699ef35a3956e9e4006665d5891fd599d1fa765894a5323"

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${datadir}/Nuand/bladeRF
    install -m 0644 ${S}/hostedx40.rbf ${D}${datadir}/Nuand/bladeRF/hostedx40.rbf
    install -m 0644 ${S}/hostedx115.rbf ${D}${datadir}/Nuand/bladeRF/hostedx115.rbf
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/Nuand/bladeRF"
