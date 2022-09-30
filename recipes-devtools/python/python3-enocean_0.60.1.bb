DESCRIPTION = "Python declarative parser for binary data"
HOMEPAGE = "http://construct.readthedocs.org/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c10a04732249c6efac3893a9f1a791e"

SRC_URI[md5sum] = "fa9338bb68760c51475ab0e58712d016"
SRC_URI[sha256sum] = "dba314dffd35ed05300a14056ef6b4e801260b233126edee9dc9107a2578c57c"

PYPI_PACKAGE = "enocean"
inherit pypi setuptools3
RDEPENDS_${PN} += "python3-core python3-pyserial python3-debugger python3-beautifulsoup4"
