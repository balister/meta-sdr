DESCRIPTION = "The Internet Communications Engine"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://ICE_LICENSE;md5=3dc3037023cc2ae6b2c5b995da529515"

BBCLASSEXTEND = "native"

DEPENDS += "db bzip2 mcpp expat openssl"

SRC_URI = "http://www.zeroc.com/download/Ice/3.5/Ice-${PV}.tar.gz \
           file://0001-Modify-Makefile-for-cross-compile.patch \
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

PYTHON_MAJMIN = "2.6"

FILES_${PN} += "${prefix}/slice"
FILES_${PN}-doc += "${prefix}/LICENSE ${prefix}/ICE_LICENSE"

inherit autotools 

do_configure() {
	:
}

do_install () {
        oe_runmake prefix=${D}${prefix} install
}


