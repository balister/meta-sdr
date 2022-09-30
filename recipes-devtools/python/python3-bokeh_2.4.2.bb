SUMMARY = "bokeh Bokeh is a Python library for creating interactive visualizations for modern web browsers. It helps you build beautiful graphics, ranging from simple plots to complex dashboards with streaming datasets. With Bokeh, you can create JavaScript-powered visualizations without writing any JavaScript yourself"
HOMEPAGE = "https://bokeh.org/"
SECTION = "devel/python"
LICENSE = "BSD 3-Clause New or Revised License"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8ada4b0ebe4fbabce1547c58b10b7019"

SRC_URI[md5sum] = "5553a6892746d017358a5732ce46a909"
SRC_URI[sha256sum] = "f0a4b53364ed3b7eb936c5cb1a4f4132369e394c7ae0a8ef420459410958033d"

DEPENDS = "python3-tornado python3-pyyaml python3-pillow python3-numpy python3-jinja2 python3-typing-extensions" 

PYPI_PACKAGE = "bokeh"


inherit pypi setuptools3

BBCLASSEXTEND = "native"
RDEPENDS_${PN}_class-native = ""
