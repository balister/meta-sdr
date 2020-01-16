SUMMARY = "Universal Hardware Driver for Ettus Research products."
HOMEPAGE = "http://www.ettus.com"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

DEPENDS = "git-native python3-mako-native boost uhd-firmware \
           ncurses udev python3-requests-native python3-numpy-native \
           python3-urllib3-native python3-chardet-native python3-certifi-native \
           python3-idna-native \
"
RDEPENDS_${PN} += "uhd-firmware python-core python3-core python3-requests"

inherit cmake python3native

PACKAGES =+ "${PN}-tests ${PN}-examples ${PN}-e1xx"

INSANE_SKIP_${PN} = "dev-so"

FILES_${PN} += "${libdir}/libuhd.so \
                ${libdir}/uhd/utils/*"
FILES_${PN}-tests += "${datadir}/uhd/tests/*"
FILES_${PN}-dev += "${libdir}/cmake/*"
FILES_${PN}-dbg += "${libdir}/uhd/examples/.debug/* \
                    ${libdir}/uhd/utils/.debug/* \
                    ${libdir}/uhd/utils/latency/.debug/* \
                    ${libdir}/uhd/tests/.debug/* \
                    ${libdir}/uhd/usrp_e_utils/.debug/*"
FILES_${PN}-examples = "${libdir}/uhd/examples/*"

PACKAGECONFIG ??= "e100 e300 b100 b200 usrp1 usrp2 x300"
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

PACKAGECONFIG[e100] = "-DENABLE_E100=ON,-DENABLE_E100=OFF, "
PACKAGECONFIG[e300] = "-DENABLE_E300=ON -DENABLE_GPSD=ON,-DENABLE_E300=OFF -DENABLE_GPSD=OFF, gpsd"
PACKAGECONFIG[b100] = "-DENABLE_B100=ON,-DENABLE_B100=OFF, libusb1"
PACKAGECONFIG[b200] = "-DENABLE_B200=ON,-DENABLE_B200=OFF, libusb1"
PACKAGECONFIG[n230] = "-DENABLE_N230=ON,-DENABLE_N230=OFF, "
PACKAGECONFIG[usrp1] = "-DENABLE_USRP1=ON,-DENABLE_USRP1=OFF, libusb1"
PACKAGECONFIG[usrp2] = "-DENABLE_USRP2=ON,-DENABLE_USRP2=OFF, "
PACKAGECONFIG[x300] = "-DENABLE_X300=ON,-DENABLE_X300=OFF, "

EXTRA_OECMAKE = "-DENABLE_LIBUHD=TRUE \
                 -DENABLE_PYTHON3=TRUE \
                 -DPYTHON_EXECUTABLE=${PYTHON}"
