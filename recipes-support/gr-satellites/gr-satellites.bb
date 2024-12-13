SUMMARY = "gr-satellites is a GNU Radio out-of-tree module encompassing a collection of telemetry decoders that supports many different Amateur satellites."
HOMEPAGE = "https://github.com/daniestevez/gr-satellites"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


DEPENDS = "python3-construct python3-requests orc orc-native feh"
RDEPENDS:${PN} = "gnuradio python3-click python3-construct python3-requests orc feh"

inherit gnuradio-oot

PV = "5.6.0+git${SRCPV}"

SRC_URI = "git://github.com/daniestevez/gr-satellites;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "e26c1f96679190d3b237be784b3374f951362362"

