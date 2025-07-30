SUMMARY = "Automatic Information System decoder for shipborne position reporting for the Gnuradio project"
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=2f64aa5c06f8d667b76f72180213a1f0"

RDEPENDS:${PN} = "gnuradio"

inherit gnuradio-oot 

PV = "0.0.3+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-ais;branch=maint-3.10;protocol=https \
          "
SRCREV = "fd72dd564470f55eea664271a026c892c69c6784"

