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

SRC_URI[x40.md5sum] = "03726935ab8e755f1ab2ead2e6032bb9"
SRC_URI[x40.sha256sum] = "517de44d7ad8cdc0e88b0d3d8945a580a1c9a25fb90ec9f0b1fd34fe30a2e8ff"

SRC_URI[x115.md5sum] = "aedc67cff1bf0b7ec237a3c122dfeccd"
SRC_URI[x115.sha256sum] = "fbbe05efcac213cc65aeb9b1235b2341595be08b11b0d3ea9ff0071ac60ad19c"

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
