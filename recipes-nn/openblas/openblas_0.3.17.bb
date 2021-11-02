DESCRIPTION = "OpenBLAS is an optimized BLAS library based on GotoBLAS2 1.13 BSD version."
SUMMARY = "OpenBLAS : An optimized BLAS library"
HOMEPAGE = "http://www.openblas.net/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5adf4792c949a00013ce25d476a2abc0"


SRC_URI = "\
    https://github.com/xianyi/OpenBLAS/archive/v${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
    file://0001-Modify-makefile-for-yocto.patch \
"

SRC_URI[sha256sum] = "df2934fa33d04fd84d839ca698280df55c690c86a5a1133b3f7266fce1de279f"


S = "${WORKDIR}/OpenBLAS-${PV}"

def map_arch(d):
    import re
    arch = d.getVar('TARGET_ARCH', True)
    if   re.match('i.86$', arch):    return 'ATOM'
    elif re.match('x86_64$', arch):  return 'ATOM'
    elif re.match('aarch32$', arch): return 'CORTEXA9'
    elif re.match('aarch64$', arch): return 'ARMV8'
    return 'CORTEXA15'

def map_bits(d):
    import re
    arch = d.getVar('TARGET_ARCH', True)
    if   re.match('i.86$', arch):    return 32
    elif re.match('x86_64$', arch):  return 64
    elif re.match('aarch32$', arch): return 32
    elif re.match('aarch64$', arch): return 64
    return 32

EXTRA_OEMAKE = "\
    ONLY_CBLAS=1 \
    HOSTCC=${BUILD_CC} \
    CROSS=1 \
    CROSS_SUFFIX=${TARGET_PREFIX} \
    BINARY=${@map_bits(d)} \
    TARGET=${@map_arch(d)} \
    OPENBLAS_LIBRARY_DIR=${D}${libdir} \
"

do_install() {
    oe_runmake PREFIX=${D}${prefix} install
    rm -rf ${D}${bindir} ${D}${libdir}/cmake
}

FILES_${PN}-dev = "${includedir} ${libdir}/lib${PN}.so"
FILES_${PN}     = "${libdir}/*"
