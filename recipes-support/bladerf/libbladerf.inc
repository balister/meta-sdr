DESCRIPTION = "Nuand bladeRF library and associatied utilities"
HOMEPAGE = "http://www.nuand.com"

# libbladeRF is licensed under LGPLv2.1
# The utilities built atop of it are licensed under GPLv2
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0ff4664e524370b0ae378dd697719e3b \
    file://legal/licenses/LICENSE.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://legal/licenses/LICENSE.LGPLv2.1;md5=4b54a1fd55a448865a0b32d41598759d \
    "

LIBBLADERF_MAJOR_VER ?= "0"

DEPENDS = "libusb1 libtecla"
RDEPENDS_${PN} += "bladerf-fpga"
RDEPENDS_${PN}-bin += "libtecla"

INC_PR = "r0"
SRC_URI = "git://github.com/Nuand/bladeRF.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
                  -DUDEV_RULES_PATH=${sysconfdir}/udev/rules.d \
                 "

FILES_${PN}${LIBBLADERF_MAJOR_VER} += "${libdir} ${sysconfdir}/udev/rules.d"
FILES_${PN}-bin = "${bindir}"

inherit pkgconfig cmake lib_package
