SUMMARY = "This is a collection of custom blocks that are not directly associated with a project. "
HOMEPAGE = "https://github.com/bastibl/gr-foo/tree/maint-3.10"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot

PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/bastibl/gr-foo;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "0a34f68565863218c3c010e69f6bd6a9bdfd7142"

