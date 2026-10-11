SUMMARY = "The sip module support for PyQt6"
HOMEPAGE = "https://pypi.org/project/PyQt6-sip/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bc996f4e03c98eae60de43496026f863"

SRC_URI[sha256sum] = "2cd55f575cde208c398d6cfdecc5a13394ed2afb54226210c50e3a6df7c3a997"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pyqt6_sip"

RDEPENDS:${PN} += "python3-core"
