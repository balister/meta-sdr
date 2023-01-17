SUMMARY = "OsmocomSDR gnuradio block set"
HOMEPAGE = "http://sdr.osmocom.org/trac/wiki/GrOsmoSDR"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio python3-six-native python3-pybind11-native \
           python3-mako-native python3-numpy-native"

# Use PACKAGECONFIG:pn-gr-osmosdr = "uhd hackrf"
# to build gr-osmosdr for uhd and hackrf. This variable goes in
# local.conf or other suitable distro conf file.
PACKAGECONFIG ??= "rtl-sdr"

PACKAGECONFIG[uhd] = "-DENABLE_UHD=ON,-DENABLE_UHD=OFF,uhd, "
PACKAGECONFIG[rtl-sdr] = "-DENABLE_RTL=ON -DENABLE_RTL_TCP=ON,\
                         -DENABLE_RTL=OFF -DENABLE_RTL_TCP=OFF,rtl-sdr, "
PACKAGECONFIG[airspy] = "-DENABLE_AIRSPY=ON,-DENABLE_AIRSPY=OFF,libairspy, "
PACKAGECONFIG[bladerf] = "-DENABLE_BLADERF=ON,-DENABLE_BLADERF=OFF,libbladerf, "
PACKAGECONFIG[hackrf] = "-DENABLE_HACKRF=ON,-DENABLE_HACKRF=OFF,libhackrf, "
PACKAGECONFIG[rfspace] = "-DENABLE_RFSPACE=ON,-DENABLE_RFSPACE=OFF, , "

inherit setuptools3-base cmake pkgconfig

EXTRA_OECMAKE = "-DENABLE_DEFAULT=OFF -DENABLE_PYTHON=ON"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES:${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.2.4"

SRC_URI = "git://git.osmocom.org/gr-osmosdr;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "82d6b6db78c829ddf7511826bd2b64be2bc189d5"
