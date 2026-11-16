SUMMARY = "OsmocomSDR gnuradio block set"
HOMEPAGE = "https://gitea.osmocom.org/sdr/gr-osmosdr"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

INSANE_SKIP:${PN}-dev = "buildpaths"

DEPENDS = "python3-six-native python3-mako-native"

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

inherit gnuradio-oot

EXTRA_OECMAKE = "-DENABLE_DEFAULT=OFF -DENABLE_PYTHON=ON"

PV = "0.2.6+git"

SRC_URI = "git://gitea.osmocom.org/sdr/gr-osmosdr.git;branch=master;protocol=https \
           file://0001-CMakeLists.txt-Don-t-require-the-Boost-system-compon.patch \
           file://0002-Use-the-keyword-form-of-GR_REGISTER_COMPONENT.patch \
           file://0003-lib-Install-the-library-without-GR_LIBRARY_FOO.patch \
          "
SRCREV = "2f230c42d2e7471769041430973776250b8f6d1d"
