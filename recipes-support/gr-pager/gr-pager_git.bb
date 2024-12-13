SUMMARY = "This is an out-of-tree (OOT) module for GNU Radio which can demodulate and decode Motorola FLEX radiopager signals. "
HOMEPAGE = "https://github.com/troycurtisjr/gr-pager"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot

PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-pager.git;branch=maint-3.10;protocol=https \
          "
SRCREV = "7df10f41709af2841058a7f42b3d641ee508d10e"

S = "${WORKDIR}/git"

