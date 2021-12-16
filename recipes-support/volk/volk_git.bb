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

PV = "2.5.0"
SRC_URI = "gitsm://github.com/gnuradio/volk.git;branch=master;protocol=https \
           file://0001-Modify-ctest-so-we-can-package-the-testfiles-and-ins.patch \
           file://run-ptest \
          "
SRC_URI:append_ettus-e300 = "file://volk_config"

S = "${WORKDIR}/git"

SRCREV = "237a6fc9242ea8c48d2bbd417a6ea14feaf7314a"

PACKAGES += "${PN}-modtool"

FILES:${PN} += "${ROOT_HOME}/.volk"
FILES:${PN}-modtool = "${bindir}/volk_modtool \
                       ${PYTHON_SITEPACKAGES_DIR}/volk_modtool"
FILES:${PN}-dev += "${libdir}/cmake"

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

