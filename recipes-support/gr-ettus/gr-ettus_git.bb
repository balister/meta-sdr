SUMMARY = "Experimental UHD and USRP features for GNU Radio."
HOMEPAGE = "https://github.com/EttusResearch/gr-ettus"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gnuradio uhd"

inherit setuptools cmake

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/*"

PV = "0.0.2+git${SRCPV}"

SRC_URI = "git://github.com/EttusResearch/gr-ettus.git;branch=master \
          "
S = "${WORKDIR}/git"

SRCREV = "fc9f67660a146caf4ff37572056d12ba8920fbae"

EXTRA_OECMAKE = " \
                 -DQT_HEADERS_DIR=${STAGING_INCDIR}/qt4 \
                 -DQT_QTCORE_INCLUDE_DIR=${STAGING_INCDIR}/qt4/QtCore \
                 -DQT_LIBRARY_DIR=${STAGING_LIBDIR} \
                 -DQT_QTCORE_LIBRARY_RELEASE=${STAGING_LIBDIR}/libQtCore.so \
                 -DQT_QTGUI_LIBRARY_RELEASE=${STAGING_LIBDIR}/libQtGui.so \
                "
