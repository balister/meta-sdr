require recipes-support/uhd/uhd.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "http://files.ettus.com/binaries/uhd/uhd_003.010.001.001-release/${PN}-${PV}.tar.gz \
          "
SRC_URI[md5sum] = "7b33dffef36c7c029104a49b0151b1ae"
SRC_URI[sha256sum] = "b0c9b1c4e6691f61e13805b74c56d3261ee98c528e96a0992e169fdc24309178"

S = "${WORKDIR}/UHD_3.10.1.1_release"

EXTRA_OECMAKE_append = " -DUHD_RELEASE_MODE=release"
