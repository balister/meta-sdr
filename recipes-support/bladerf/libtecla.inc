SUMMARY = "Library for interactive command line editing"
HOMEPAGE = "http://www.astro.caltech.edu/~mcs/tecla/"
AUTHOR = "Martin Shepherd"

DESCRIPTION = "The tecla library provides UNIX and LINUX programs with \
interactive command line editing facilities, similar to those of the UNIX tcsh \
shell. In addition to simple command-line editing, it supports recall of \
previously entered command lines, TAB completion of file names or other \
tokens, and in-line wild-card expansion of filenames. The internal functions \
which perform file-name completion and wild-card expansion are also available \
externally for optional use by programs."

SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.TERMS;md5=36e990266b063a55483b4410333243d2"

DEPENDS += "ncurses"

S = "${WORKDIR}/libtecla/"

inherit autotools-brokensep pkgconfig

SRC_URI = "http://www.astro.caltech.edu/~mcs/tecla/libtecla-${PV}.tar.gz;name=archive"

LIBTECLA_MAJOR_VER ?= "1"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN}${LIBTECLA_MAJOR_VER} += "${libdir}"
FILES_${PN}-bin += "${bindir}"
FILES_${PN}-dev += "${includedir}"

do_configure_prepend() {
    # We want these to be regenerated, as the shipped versions include commands
    # that will use host files/commands rather than those of the
    # cross-toolchain.
    rm -f configure
    rm -f Makefile
}

do_install() {
    install -d ${D}${includedir}
    install -m 0644 ${S}libtecla.h ${D}${includedir}/libtecla.h

    install -d ${D}${libdir}
    oe_libinstall -s libtecla ${D}${libdir}

    install -d ${D}${bindir}
    install -m 0755 ${S}enhance ${D}${bindir}/enhance
}

