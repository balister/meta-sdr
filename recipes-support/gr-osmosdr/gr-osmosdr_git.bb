SUMMARY = "OsmocomSDR gnuradio block set"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/GrOsmoSDR"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio"

# Use PACKAGECONFIG_pn-gr-osmosdr = "uhd hackrf"
# to build gr-osmosdr for uhd and hackrf. This variable goes in
# local.conf or other suitable distro conf file.
PACKAGECONFIG ??= "uhd rtl-sdr hackrf rfspace"

PACKAGECONFIG[uhd] = "-DENABLE_UHD=ON,-DENABLE_UHD=OFF,uhd, "
PACKAGECONFIG[rtl-sdr] = "-DENABLE_RTL=ON -DENABLE_RTL_TCP=ON,\
                         -DENABLE_RTL=OFF -DENABLE_RTL_TCP=OFF,rtl-sdr, "
PACKAGECONFIG[bladerf] = "-DENABLE_BLADERF=ON,-DENABLE_BLADERF=OFF,libbladerf, "
PACKAGECONFIG[hackrf] = "-DENABLE_HACKRF=ON,-DENABLE_HACKRF=OFF,libhackrf, "
PACKAGECONFIG[rfspace] = "-DENABLE_RFSPACE=ON,-DENABLE_RFSPACE=OFF, , "

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"


FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.1.4.1"

SRC_URI = "git://git.osmocom.org/gr-osmosdr;branch=master \
           file://0001-staticlibs.patch \
           file://cross-64.patch \
           file://0001-Use-CMAKE_INSTALL_LIBDIR-to-set-LIB_SUFFIX.patch \
           file://0001-allow-both-3.7.-and-git-version-of-GnuRadio.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "a45968f3381f33b86ca344bb76bd62c131d98d93"
