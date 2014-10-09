DESCRIPTION = "Pre-built FPGA bitstreams for the Nuand bladeRF"
HOMEPAGE = "http://www.nuand.com"

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

S = "${WORKDIR}"
FPGA_DIR = "${datadir}/Nuand/bladeRF"
FILES_${PN} = "${FPGA_DIR}"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${FPGA_DIR}
    install -m 0644 ${S}/hostedx40.rbf ${D}${FPGA_DIR}/hostedx40.rbf
    install -m 0644 ${S}/hostedx115.rbf ${D}${FPGA_DIR}/hostedx115.rbf
}

PACKAGES = "${PN}"
