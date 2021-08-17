SUMMARY = "The Vector Optimized Library of Kernels"
HOMEPAGE = "http://libvolk.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "boost python3-mako-native python3-six-native"

inherit python3native cmake pkgconfig ptest

PACKAGECONFIG ??= ""
PACKAGECONFIG[orc] = "-DENABLE_ORC=ON,-DENABLE_ORC=OFF,orc, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR

PV = "2.4.1"
SRC_URI = "gitsm://github.com/gnuradio/volk.git;branch=master \
           file://0001-Modify-ctest-so-we-can-package-the-testfiles-and-ins.patch \
           file://run-ptest \
          "
SRC_URI:append_ettus-e300 = "file://volk_config"

S = "${WORKDIR}/git"

SRCREV = "797b0ac846858d081fbb53ed50e98765ec9cb6b2"

PACKAGES += "${PN}-modtool"

FILES_${PN} += "${ROOT_HOME}/.volk"
FILES_${PN}-modtool = "${bindir}/volk_modtool \
                       ${PYTHON_SITEPACKAGES_DIR}/volk_modtool"
FILES_${PN}-dev += "${libdir}/cmake"

do_install:append() {
	if [ -e ${WORKDIR}/volk_config ]; then
		install -d ${D}/${ROOT_HOME}/.volk
		install -m 644 ${WORKDIR}/volk_config ${D}/${ROOT_HOME}/.volk
	fi
}

do_install_ptest() {
    mkdir -p ${D}${PTEST_PATH}
    cd ${B}
    find . -name "CTestTestfile.cmake" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name "volk*test.sh" -exec cp --parents {} ${D}${PTEST_PATH} \;
    install -m 0755 lib/volk_test_all ${D}/${PTEST_PATH}
}

