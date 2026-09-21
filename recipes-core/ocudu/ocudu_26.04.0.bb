SUMMARY = "OCUDU: open-source 5G (and beyond) CU/DU RAN stack"
HOMEPAGE = "https://ocudu.org"
LICENSE = "BSD-3-Clause-Open-MPI"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fae65c7adb716b4df19c4fc7f7e06e01"

SRC_URI = "git://gitlab.com/ocudu/ocudu.git;nobranch=1;tag=release_26_04;protocol=https"
SRCREV = "050a2bb72e1d794cd60570d809987c1fcda3e54b"

S = "${UNPACKDIR}/${BP}"

DEPENDS = "fftw mbedtls lksctp-tools yaml-cpp"

inherit cmake pkgconfig

# OCUDU's own CMakeLists.txt defaults MCPU (aarch64) / MARCH (x86_64) to
# "native", which a cross compiler cannot honor (there's no local CPU to
# probe). Pin it to this MACHINE's actual tune instead. A second, unrelated
# MARCH cache var (default "native" too) is declared from scratch in
# lib/phy/upper/channel_coding/CMakeLists.txt to probe for the ARMv8 crypto
# extension (+crypto); give it a real baseline ISA name instead.
EXTRA_OECMAKE:append:aarch64 = " -DMCPU=${@(d.getVar('TUNE_CCARGS') or '').split('-mcpu=')[-1].split()[0] if '-mcpu=' in (d.getVar('TUNE_CCARGS') or '') else 'generic'} -DMARCH=armv8-a"
EXTRA_OECMAKE:append:x86-64 = " -DMARCH=x86-64 -DMTUNE=generic"

# ENABLE_MKL/FFTZ/ARMPL are vendor-specific FFT accelerators (Intel MKL, AMD
# FFTZ, Arm Performance Libraries) with no corresponding OE recipes.
# ENABLE_BACKWARD pulls in elfutils (libdw/libelf) purely for nicer
# backtraces on crash; left off by default to keep DEPENDS lean, available
# as a PACKAGECONFIG. ENABLE_WERROR is disabled since upstream only
# validates against the exact GCC/Clang versions in their own CI.
EXTRA_OECMAKE += "-DENABLE_WERROR=OFF \
                   -DENABLE_MKL=OFF \
                   -DENABLE_FFTZ=OFF \
                   -DENABLE_ARMPL=OFF \
"

# Core CU/CP/UP/DU/gNB apps require mbedtls (security) and SCTP (F1AP/E1AP/
# NGAP transport), so those stay hard DEPENDS above rather than
# PACKAGECONFIG options.
PACKAGECONFIG ??= "uhd"
PACKAGECONFIG[uhd] = "-DENABLE_UHD=ON,-DENABLE_UHD=OFF,uhd"
PACKAGECONFIG[zeromq] = "-DENABLE_ZEROMQ=ON,-DENABLE_ZEROMQ=OFF,zeromq cppzmq"
PACKAGECONFIG[backward] = "-DENABLE_BACKWARD=ON,-DENABLE_BACKWARD=OFF,elfutils"
PACKAGECONFIG[tests] = "-DBUILD_TESTING=ON,-DBUILD_TESTING=OFF,googletest"

# cmake-sbom's generated SBOM is build-time supply-chain metadata, not
# something the target needs at runtime.
do_install:append() {
    rm -f ${D}${datadir}/ocudu.spdx
}
