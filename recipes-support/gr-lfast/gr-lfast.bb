SUMMARY = "The goal of the gr-lfast project is to increase flowgraph performance while running on a general purpose CPU. So far the project uses several techniques to achieve the performance boosts:"
HOMEPAGE = "https://github.com/ghostop14/gr-lfast"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

RDEPENDS:${PN} = "gnuradio python3-click volk"

inherit gnuradio-oot

PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/ghostop14/gr-lfast;branch=master;protocol=https \
           file://0001-adding-neon-support.patch \
           "
SRCREV = "63b1e185ea09453e7f287bae8a62924c868c6b33"

