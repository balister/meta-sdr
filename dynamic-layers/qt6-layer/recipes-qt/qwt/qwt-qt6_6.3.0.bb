SUMMARY = "Qt Widget Extension for Technical Applications"
SECTION = "libs"
HOMEPAGE = "https://qwt.sourceforge.io/"

# LGPLv2.1 + some exceptions
LICENSE = "LicenseRef-QWTv1.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=dac2743472b0462ff3cfb4af42051c88"
NO_GENERIC_LICENSE[LicenseRef-QWTv1.0] = "COPYING"

DEPENDS = "qtbase qtsvg"

inherit qt6-qmake pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/qwt/qwt-${PV}.tar.bz2"
SRC_URI[sha256sum] = "dcb085896c28aaec5518cbc08c0ee2b4e60ada7ac929d82639f6189851a6129a"

S = "${UNPACKDIR}/qwt-${PV}"

# Headers go in their own directory so they don't collide with a Qt5 build
# of Qwt; gnuradio's FindQwt.cmake searches the qwt-qt6 suffix.
QWT_INCDIR = "${includedir}/qwt-qt6"

do_configure:prepend() {
    sed -i \
        -e 's|^\( *QWT_INSTALL_PREFIX *=\).*|\1 ${prefix}|' \
        -e 's|^QWT_INSTALL_DOCS .*|QWT_INSTALL_DOCS = ${docdir}/${BPN}|' \
        -e 's|^QWT_INSTALL_HEADERS .*|QWT_INSTALL_HEADERS = ${QWT_INCDIR}|' \
        -e 's|^QWT_INSTALL_LIBS .*|QWT_INSTALL_LIBS = ${libdir}|' \
        -e 's|^QWT_INSTALL_FEATURES .*|QWT_INSTALL_FEATURES = ${OE_QMAKE_PATH_ARCHDATA}/mkspecs/features|' \
        -e 's|^QWT_CONFIG *+= QwtDesigner$|#&|' \
        -e 's|^QWT_CONFIG *+= QwtExamples$|#&|' \
        -e 's|^QWT_CONFIG *+= QwtPlayground$|#&|' \
        -e 's|^QWT_CONFIG *+= QwtTests$|#&|' \
        ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', "-e 's|^QWT_CONFIG *+= QwtOpenGL$|#&|'", d)} \
        ${S}/qwtconfig.pri

    # Upstream hardcodes Qt5 module names in the generated pkg-config file
    sed -i -e 's|Qt5\([A-Za-z]*\)|Qt$${QT_MAJOR_VERSION}\1|g' ${S}/src/src.pro
}

FILES:${PN}-dev += "${OE_QMAKE_PATH_ARCHDATA}/mkspecs/features"

RPROVIDES:${PN}-dev = "libqwt-qt6-dev"
