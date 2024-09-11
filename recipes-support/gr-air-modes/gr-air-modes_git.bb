SUMMARY = "A mode S receiver for GNU Radio."
HOMEPAGE = "https://github.com/bistromath/gr-ais"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio sqlite3 gr-osmosdr python3-pybind11-native python3-native python3-numpy-native"
RDEPENDS:${PN} = "gnuradio"

inherit setuptools3 cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES:${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/bkerler/gr-air-modes;branch=maint-3.10;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "3a946c55f74da8395158b43fc69aab3902432aca"
PYTHON_MAJMIN = "3.12"

EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/python${PYTHON_MAJMIN} \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DENABLE_DOXYGEN=OFF \
    "
