HOMEPAGE = "https://github.com/python/typing"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64fc2b30b67d0a8423c250e0386ed72f"

# The name on PyPi is slightly different.
PYPI_PACKAGE = "typing_extensions"

SRC_URI[sha256sum] = "49f75d16ff11f1cd258e1b988ccff82a3ca5570217d7ad8c5f48205dd99a677e"

inherit pypi
inherit setuptools3

BBCLASSEXTEND = "native nativesdk"

UPSTREAM_CHECK_REGEX = "/typing-extensions/(?P<pver>(\d+[\.\-_]*)+)/"
