SUMMARY = "OsmocomSDR gnuradio block set"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/GrOsmoSDR"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio swig-native python-cheetah-native"

# Use PACKAGECONFIG_pn-gr-osmosdr = "uhd hackrf"
# to build gr-osmosdr for uhd and hackrf. This variable goes in
# local.conf or other suitable distro conf file.
PACKAGECONFIG ??= "rtl-sdr airspy hackrf rfspace"

PACKAGECONFIG[uhd] = "-DENABLE_UHD=ON,-DENABLE_UHD=OFF,uhd, "
PACKAGECONFIG[rtl-sdr] = "-DENABLE_RTL=ON -DENABLE_RTL_TCP=ON,\
                         -DENABLE_RTL=OFF -DENABLE_RTL_TCP=OFF,rtl-sdr, "
PACKAGECONFIG[airspy] = "-DENABLE_AIRSPY=ON,-DENABLE_AIRSPY=OFF,libairspy, "
PACKAGECONFIG[bladerf] = "-DENABLE_BLADERF=ON,-DENABLE_BLADERF=OFF,libbladerf, "
PACKAGECONFIG[hackrf] = "-DENABLE_HACKRF=ON,-DENABLE_HACKRF=OFF,libhackrf, "
PACKAGECONFIG[rfspace] = "-DENABLE_RFSPACE=ON,-DENABLE_RFSPACE=OFF, , "

inherit distutils3-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.2.0"

SRC_URI = "git://git.osmocom.org/gr-osmosdr;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "af2fda22b3b3745520ef38e9aaa757484871ee0c"
