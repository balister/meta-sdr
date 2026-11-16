SUMMARY = "The Vector Optimized Library of Kernels"
HOMEPAGE = "http://libvolk.org"
LICENSE = "LGPL-3.0-only AND Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3000208d539ec061b899bce1d9ce9404 \
                    file://cpu_features/LICENSE;md5=31a8379f6fe09baf921e654832ac5700 \
                   "

DEPENDS = "python3-mako-native python3-six-native fmt"

inherit python3native cmake pkgconfig ptest

PACKAGECONFIG ??= ""
PACKAGECONFIG[orc] = "-DENABLE_ORC=ON,-DENABLE_ORC=OFF,orc, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

export BUILD_SYS
export HOST_SYS = "${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR

PV = "3.3.0+git"
SRC_URI = "git://github.com/gnuradio/volk.git;branch=main;protocol=https;name=volk \
           git://github.com/google/cpu_features.git;branch=main;protocol=https;name=cpu-features;destsuffix=${BP}/cpu_features \
           file://0001-Modify-ctest-so-we-can-package-the-testfiles-and-ins.patch \
           file://0001-Do-not-compile-compiler-flags-into-volk.-This-leaks-.patch \
           file://run-ptest \
          "
SRC_URI:append:ettus-e300 = " file://volk_config"
SRC_URI:append:zynqmp-zcu104-sdt-full = " file://volk_config"

SRCREV_volk = "453f289d93c641f53e1b139aef3373b089abe007"
# v0.11.0, the version upstream volk fetches with FetchContent
SRCREV_cpu-features = "81d13c49649f0714dd41fb56bb246398b6584085"
SRCREV_FORMAT = "volk"

# volk no longer has a cpu_features submodule; point FetchContent at our copy.
# Keep it inside ${S} so the debug prefix map covers its sources.
EXTRA_OECMAKE += "-DFETCHCONTENT_SOURCE_DIR_CPU_FEATURES=${S}/cpu_features"

PACKAGES += "${PN}-modtool"

FILES:${PN} += "${ROOT_HOME}/.volk"
FILES:${PN}-modtool = "${bindir}/volk_modtool \
                       ${PYTHON_SITEPACKAGES_DIR}/volk_modtool"
FILES:${PN}-dev += "${libdir}/cmake"

# run-ptest uses ctest
RDEPENDS:${PN}-ptest += "cmake"

do_install:append() {
	if [ -e ${UNPACKDIR}/volk_config ]; then
		install -d ${D}/${ROOT_HOME}/.volk
		install -m 644 ${UNPACKDIR}/volk_config ${D}/${ROOT_HOME}/.volk
	fi
}

do_install:append() {
    find ${D} -name "*.pyc" -exec rm {} \;
    find ${D} -name "*.pyo" -exec rm {} \;
}

do_install_ptest() {
    mkdir -p ${D}${PTEST_PATH}
    cd ${B}
    find . -path ./_deps -prune -o -name "CTestTestfile.cmake" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find ${D}${PTEST_PATH} -name "CTestTestfile.cmake" -exec sed -i "s|${B}||g" {} \;
    find ${D}${PTEST_PATH} -name "CTestTestfile.cmake" -exec sed -i "s|${S}||g" {} \;


    find . -name "volk*test.sh" -exec cp --parents {} ${D}${PTEST_PATH} \;
    install -m 0755 lib/volk_test_all ${D}/${PTEST_PATH}
}

