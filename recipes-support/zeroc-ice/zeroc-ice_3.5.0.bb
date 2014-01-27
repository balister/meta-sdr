DESCRIPTION = "The Internet Communications Engine"
LICENSE = "GPLv2"
PR = "r0"

LIC_FILES_CHKSUM = "file://ICE_LICENSE;md5=3dc3037023cc2ae6b2c5b995da529515"

PARALLEL_MAKE = ""

DEPENDS += "bzip2 mcpp expat openssl python zeroc-slice-native"

SRC_URI = "http://www.zeroc.com/download/Ice/3.5/Ice-${PV}.tar.gz \
           file://cross-makefile.patch \
          "

#	file://20-kfreebsd.patch 
#	file://20-missing-monotonic.patch 
#	file://30-bashisms-cs-makefile.patch 
#	file://10-build-qt-sql.patch 
#	file://05-lightweight-cpp-make.patch 
#	file://10-debug-flags.patch 
#	file://10-java-policy.patch 
#	file://10-install-pylibdir.patch 
#	file://10-install-rblibdir.patch 
#	file://10-install-clibindir.patch 
#	file://archs.patch 
#	file://libdb5.1.patch 
#	file://ptrdiff_t-gcc-4.6.patch 
#	file://cpp-make-rules.patch 
#	file://make-cross.patch" 

SRC_URI[md5sum] = "a79d4fc17a6774fcf47950694fad99cb"
SRC_URI[sha256sum] = "bbde6b5a87f5abc8d9105468731f1419829bc22b5d23b8fdef553967a2eebdb0"

S = "${WORKDIR}/Ice-${PV}"

inherit autotools python-dir

#TARGET_CC_ARCH += "${LDFLAGS}"

PYTHON_MAJMIN = "2.7"

ICE_HOME = "${prefix}"

do_compile_prepend() {
        # python stuff
        sed -i 's:^PYTHON_VERSION.*:PYTHON_VERSION ?= python${PYTHON_MAJMIN}:' ${S}/py/config/Make.rules
        sed -i 's:^PYTHON_INCLUDE_DIR.*:PYTHON_INCLUDE_DIR ?= ${STAGING_INCDIR}/${PYTHON_DIR}:' ${S}/py/config/Make.rules
        sed -i 's:^PYTHON_LIB_DIR.*:PYTHON_LIB_DIR ?= ${libdir}/${PYTHON_DIR}:' ${S}/py/config/Make.rules
}


do_configure() {
	:
}

do_compile() {
	oe_runmake -C ${S} cpp
	oe_runmake -C ${S} py
}

do_install() {
	oe_runmake -C ${S}/cpp prefix=${D}${prefix} install 
	oe_runmake -C ${S}/py prefix=${D}${prefix} install
}

PACKAGES += "python-${PN} ${PN}-slice python-${PN}-dev python-${PN}-dbg"

FILES_${PN}-slice = "${bindir}/slice* ${datadir}/Ice-${PV}/slice/*"
FILES_${PN}-dev += "${includedir}/* ${datadir}/Ice-${PV}/config/*"
FILES_python-${PN}-dev = "${libdir}/python${PYTHON_MAJMIN}/IcePy.so"
FILES_python-${PN} = "${libdir}/python${PYTHON_MAJMIN}/*.py ${libdir}/python${PYTHON_MAJMIN}/IcePy.so.* ${libdir}/python${PYTHON_MAJMIN}/Ice*/*.py" 
FILES_${PN} += "${prefix}/*LICENSE ${libdir}/ImportKey.class"
FILES_python-${PN}-dbg ="${libdir}/python${PYTHON_MAJMIN}/.debug"

