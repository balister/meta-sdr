SUMMARY = "A mode S receiver for GNU Radio."
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "sqlite3 gr-osmosdr"
RDEPENDS:${PN} = "gnuradio"

inherit gnuradio-oot

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-air-modes;branch=maint-3.10;protocol=https \
          "
SRCREV = "3a946c55f74da8395158b43fc69aab3902432aca"

