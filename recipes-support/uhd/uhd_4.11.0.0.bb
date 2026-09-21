SUMMARY = "Universal Hardware Driver for Ettus Research USRP products"
HOMEPAGE = "https://www.ettus.com"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=master;tag=v${PV};protocol=https"
SRCREV = "0d7ed3b1a4e301032b0c6b04799d7631c5098528"

S = "${UNPACKDIR}/${BP}/host"

DEPENDS = "boost libusb1 git-native \
           python3-mako-native python3-requests-native python3-numpy-native \
           python3-ruamel-yaml-native python3-setuptools-native \
           protobuf protobuf-native grpc grpc-native \
"

# Most CLI tools (uhd_images_downloader, rfnoc_image_builder, rfnoc_modtool,
# uhd_find_devices, ...) install straight into bindir and land in the main
# package; the pure-python "uhd" module (needed by the rfnoc_* tools) is
# packaged under ${PN}-utils.
UHD_PYTHON_RDEPENDS = "python3-core python3-mako python3-numpy python3-requests python3-ruamel-yaml"
RDEPENDS:${PN} = "${UHD_PYTHON_RDEPENDS}"
RDEPENDS:${PN}-utils = "${UHD_PYTHON_RDEPENDS}"

inherit cmake python3native pkgconfig

PACKAGES =+ "${PN}-examples ${PN}-tests ${PN}-utils"

# UHD 4.x builds every device family (B2xx, X3xx, X4xx, N3xx, E3xx, MPMD, ...)
# unconditionally; the only optional external dependency is libusb1 for the
# USB-attached devices, which is already a hard DEPENDS above.
EXTRA_OECMAKE = "-DENABLE_LIBUHD=ON \
                 -DENABLE_EXAMPLES=ON \
                 -DENABLE_UTILS=ON \
                 -DENABLE_PYMOD_UTILS=ON \
                 -DENABLE_MAN_PAGES=OFF \
                 -DENABLE_MANUAL=OFF \
                 -DENABLE_DOXYGEN=OFF \
                 -DUHD_RELEASE_MODE=release \
                 -DCMAKE_FIND_PACKAGE_PREFER_CONFIG=ON \
                 -DProtobuf_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
                 -DGRPC_CPP_PLUGIN=${STAGING_BINDIR_NATIVE}/grpc_cpp_plugin \
                 -DPYTHON_EXECUTABLE=${PYTHON} \
                 -DUHD_PYTHON_DIR=${baselib}/${PYTHON_DIR}/site-packages \
                 -DCMAKE_PROJECT_TOP_LEVEL_INCLUDES=${WORKDIR}/uhd-native-protoc.cmake \
"

# UHD's MPMD code generation calls protobuf_generate() without a PROTOC_EXE
# override, so it defaults to running the imported target "protobuf::protoc".
# In config mode that target only exists in the target-sysroot Protobuf
# package (no usable protoc binary for the build host), so inject an
# imported target that points at the real, host-executable protoc from
# protobuf-native.
do_configure:prepend() {
    cat > ${WORKDIR}/uhd-native-protoc.cmake <<EOF
if(NOT TARGET protobuf::protoc)
    add_executable(protobuf::protoc IMPORTED)
    set_target_properties(protobuf::protoc PROPERTIES
        IMPORTED_LOCATION "${STAGING_BINDIR_NATIVE}/protoc")
endif()
EOF
}

# The __pycache__ files that "python setup.py build" leaves behind embed the
# absolute build-time path of the .py source in each .pyc; drop them rather
# than ship a stale, host-specific bytecode cache (python recompiles on
# first import anyway).
do_install:append() {
    find ${D} -depth -name "__pycache__" -exec rm -rf {} +
}

# UHD links directly against libusb1's absolute .so path (via its own
# FindLIBUSB.cmake, not an imported target), so that build-tree path ends up
# baked into the exported lib/cmake/uhd/UHDTargets.cmake. Harmless for using
# the installed libuhd itself; it only affects recompiling other software
# against uhd-dev's outside of this build tree.
INSANE_SKIP:${PN}-dev += "buildpaths"
# Generated headers (lib/ic_reg_maps/*.hpp) embed the absolute path of the
# codegen script that produced them in a header comment.
INSANE_SKIP:${PN}-src += "buildpaths"

PACKAGECONFIG ??= ""
PACKAGECONFIG[tests] = "-DENABLE_TESTS=ON,-DENABLE_TESTS=OFF"
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF"
PACKAGECONFIG[python-api] = "-DENABLE_PYTHON_API=ON,-DENABLE_PYTHON_API=OFF,python3 python3-pybind11 python3-numpy"

FILES:${PN}-dev += "${libdir}/cmake/*"
FILES:${PN}-examples = "${libdir}/uhd/examples/*"
FILES:${PN}-tests = "${libdir}/uhd/tests/*"
FILES:${PN}-utils = "${libdir}/uhd/utils/* ${PYTHON_SITEPACKAGES_DIR}/uhd*"
FILES:${PN}-dbg += "${libdir}/uhd/examples/.debug/* \
                    ${libdir}/uhd/utils/.debug/* \
                    ${libdir}/uhd/tests/.debug/* \
"
