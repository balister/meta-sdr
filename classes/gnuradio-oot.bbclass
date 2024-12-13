inherit python3targetconfig setuptools3 cmake pkgconfig

DEPENDS:append = " gnuradio volk log4cpp cppunit python3-pybind11-native \
                   python3-numpy-native spdlog"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR

PYTHON_MAJMIN = "${PYTHON_BASEVERSION}"

EXTRA_OECMAKE = " \
    -DCMAKE_CROSSCOMPLIING=ON \
    -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/python${PYTHON_MAJMIN} \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP:${PN}:append = " dev-so already-stripped"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
    ${datadir}/${PN}/examples/*.grc \
"

