SUMMARY = "Nuand bladeRF library and associatied utilities"
HOMEPAGE = "http://www.nuand.com"
BUGTRACKER = "https://github.com/nuand/bladeRF/issues"

# libbladeRF is licensed under LGPLv2.1
# The utilities built atop of it are licensed under GPLv2
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=1cf6a36e0707770e89028449314775f9 \
    file://legal/licenses/LICENSE.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://legal/licenses/LICENSE.LGPLv2.1;md5=4b54a1fd55a448865a0b32d41598759d \
    "

DEPENDS = "libusb1 libtecla"

SRC_URI = "git://github.com/Nuand/bladeRF.git;protocol=git;branch=master"
SRCREV = "ab12ebd3fb843a6df53521fbc2d47c32b835f5dd"

S = "${WORKDIR}/git"

inherit pkgconfig cmake lib_package

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
                  -DUDEV_RULES_PATH=${sysconfdir}/udev/rules.d \
                  -DTAGGED_RELEASE=Yes \
                 "

LIBBLADERF_MAJOR_VER ?= "1"
FILES_${PN}${LIBBLADERF_MAJOR_VER} += "${libdir} ${sysconfdir}/udev/rules.d"
FILES_${PN}-bin = "${bindir}"

RDEPENDS_${PN} += "bladerf-fpga"
RDEPENDS_${PN}-bin += "libtecla"
