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

SRC_URI[x40.md5sum] = "ff681baa275d3f01af3d864e737a23ae"
SRC_URI[x40.sha256sum] = "85f2e237829476f6f15851a25ce96084dfc695820c37cd6751efee4c4806999a"

SRC_URI[x115.md5sum] = "899da656cfb73789febe515b9d82f67e"
SRC_URI[x115.sha256sum] = "3dea872433a4dc3410c3aa667dc18caa8c2fda0a616d325f95d6f2ef02221f90"

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
