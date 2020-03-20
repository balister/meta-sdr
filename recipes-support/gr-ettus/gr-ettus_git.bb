SUMMARY = "Experimental UHD and USRP features for GNU Radio."
HOMEPAGE = "https://github.com/EttusResearch/gr-ettus"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio uhd swig-native"

inherit setuptools3 cmake

PACKAGECONFIG ??= "qt4"

PACKAGECONFIG[qt4] = "-DENABLE_QT=ON,-DENABLE_QT=OFF,qt4-x11-free qt4-native, "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* \
                ${prefix}/etc"

PV = "0.0.4+git${SRCPV}"

SRC_URI = "git://github.com/EttusResearch/gr-ettus.git;branch=master \
           file://0001-GrPlatform.cmake-Do-not-use-build-machine-files-duri.patch \
          "
S = "${WORKDIR}/git"

SRCREV = "525b6f22850a00cc762bc094224b0e5573fe60a2"

EXTRA_OECMAKE = " \
                 -DQT_BINARY_DIR=${STAGING_BINDIR_NATIVE} \
                 -DQT_HEADERS_DIR=${STAGING_INCDIR}/qt4 \
                 -DQT_QTCORE_INCLUDE_DIR=${STAGING_INCDIR}/qt4/QtCore \
                 -DQT_LIBRARY_DIR=${STAGING_LIBDIR} \
                 -DQT_QTCORE_LIBRARY_RELEASE=${STAGING_LIBDIR}/libQtCore.so \
                 -DQT_QTGUI_LIBRARY_RELEASE=${STAGING_LIBDIR}/libQtGui.so \
                "
