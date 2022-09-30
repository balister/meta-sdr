DESCRIPTION = "An extension module for click to register external CLI commands via setuptools entry-points."
HOMEPAGE = "https://github.com/click-contrib/click-plugins"
SECTION = "devel/python"
LICENSE = "New-BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d512f1f7204a358a9323ae899c988eba"

SRC_URI[md5sum] = "969268b5b005b2b56115c66c55013252"
SRC_URI[sha256sum] = "46ab999744a9d831159c3411bb0c79346d94a444df9a3a3742e9ed63645f264b"

PYPI_PACKAGE = "click-plugins"
inherit pypi setuptools3
RDEPENDS_${PN} += "python3-core python3-six python3-debugger python3-click"
