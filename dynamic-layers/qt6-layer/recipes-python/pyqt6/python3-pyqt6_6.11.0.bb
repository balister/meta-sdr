SUMMARY = "Python Qt6 Bindings"
HOMEPAGE = "https://www.riverbankcomputing.com/software/pyqt"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[sha256sum] = "45dd60aa69976de1918b5ced6b4e7b6a25abd2a919ecef5fd5826ecc76718889"

inherit pypi python3-dir python3native qt6-qmake

PYPI_PACKAGE = "pyqt6"

SRC_URI += "file://0001-QtCore-Drop-QEvent-EnterEditFocus-and-LeaveEditFocus.patch"

DEPENDS = " \
    python3 \
    python3-packaging-native \
    python3-pyqt-builder-native \
    sip-native \
    qtbase \
    qtsvg \
"

# The modules gnuradio uses (gr-qtgui, grc, gr-filter's filter_design).
PYQT_MODULES ?= "QtCore QtGui QtWidgets QtSvg QtPrintSupport"

# sip-build normally compiles and runs PyQt's config-tests to find out which
# Qt features are missing. Their target binaries can't run on the build
# host, so remove them and disable the features qtbase isn't built with.
DISABLED_FEATURES = " \
    PyQt_Permissions \
    PyQt_SessionManager \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'PyQt_OpenGL', d)} \
    ${PYQT_ES2_FEATURE} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'PyQt_XCB', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', 'PyQt_Wayland', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', '', 'PyQt_Vulkan', d)} \
"
# qtbase uses OpenGL ES2 when opengl is enabled with wayland, or without x11
# (see PACKAGECONFIG_GRAPHICS in qtbase_git.bb); otherwise it uses desktop GL.
PYQT_ES2_FEATURE = "${@'' if bb.utils.contains('DISTRO_FEATURES', 'opengl', True, False, d) and (bb.utils.contains('DISTRO_FEATURES', 'wayland', True, False, d) or not bb.utils.contains('DISTRO_FEATURES', 'x11', True, False, d)) else 'PyQt_OpenGL_ES2'}"

do_configure:prepend() {
    cd ${S}
    rm -f config-tests/cfgtest_*.cpp

    extra_args=""
    for i in ${DISABLED_FEATURES}; do
        extra_args="$extra_args --disabled-feature=$i"
    done
    for i in ${PYQT_MODULES}; do
        extra_args="$extra_args --enable=$i"
    done

    # PyQt-builder defaults to the newest sip ABI it knows about, which can be
    # newer than the sip-native in the build; use the newest one sip provides.
    abi_minor=$(nativepython3 -c 'from sipbuild.module import get_source_version_range; print(get_source_version_range(13)[1])')

    sip-build \
        --verbose \
        --confirm-license \
        --qt-shared \
        --no-designer-plugin \
        --no-qml-plugin \
        --no-dbus-python \
        --no-make \
        --build-dir="${B}" \
        --target-dir="${PYTHON_SITEPACKAGES_DIR}" \
        --scripts-dir="${bindir}" \
        --qmake="${OE_QMAKE_QMAKE}" \
        --abi-version=13.$abi_minor \
        $extra_args

    QMAKE_PROFILES=${B}/PyQt6.pro
}

do_compile:prepend() {
    # sip-build takes the Python headers and library from the native python
    # it runs under; point the generated projects at the target's instead.
    for pro_file in $(find ${B} -name "*.pro"); do
        sed -i \
            -e "s|/[^ ]*/libpython${PYTHON_BASEVERSION}\.so|-lpython${PYTHON_BASEVERSION}|g" \
            -e "s|-L/[^ ]*/recipe-sysroot-native/[^ ]*||g" \
            -e "s|/[^ ]*/include/python${PYTHON_BASEVERSION}|${STAGING_INCDIR}/python${PYTHON_BASEVERSION}|g" \
            "$pro_file"
    done
}

do_install:append() {
    # pyuic6 and pylupdate6 are sh wrappers that exec the native python
    sed -i "s,exec .*nativepython3,exec ${bindir}/python3," ${D}${bindir}/*
}

pyqt_fix_sources() {
    find ${PKGD}${TARGET_DBGSRC_DIR} -type f -exec sed -i "s,\(${B}\|${S}\),${TARGET_DBGSRC_DIR},g" {} \;
}
PACKAGESPLITFUNCS =+ "pyqt_fix_sources"

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}"

RDEPENDS:${PN} = " \
    python3-core \
    python3-pyqt6-sip \
    qtbase \
    qtsvg \
"
