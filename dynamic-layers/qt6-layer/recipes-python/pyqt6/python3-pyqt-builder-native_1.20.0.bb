SUMMARY = "The PEP 517 compliant PyQt build system"
HOMEPAGE = "https://pypi.org/project/PyQt-builder/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=236276327275fdb261636fb40b18d88d"

SRC_URI[sha256sum] = "267ac1ee1593c67884f3c9cb6566f72a92ca28353050fc9d087433c28c74a889"

inherit pypi python_setuptools_build_meta native

PYPI_PACKAGE = "pyqt_builder"

DEPENDS += "python3-setuptools-scm-native"
RDEPENDS:${PN} += "sip-native python3-packaging-native"
