require libtecla.inc

SRC_URI[archive.md5sum] = "bc40fac0d1b882b9e523f07d33a044d1"
SRC_URI[archive.sha256sum] = "8c61db528364f4e88e34e79eb3730adf54e43c594cf12faf712117a6d20eb7b8"

SRC_URI += "file://0001-Use-CC-when-populating-LINK_SHARED.patch"
SRC_URI += "file://0002-Use-AR-in-Rules.make-rather-than-ar.patch"
SRC_URI += "file://0003-Added-TARGETS-dependency-to-demos-and-enhance-progra.patch"
SRC_URI += "file://0004-Add-GNU-Hash-ELF-section-argument-to-LINK_SHARED.patch"
SRC_URI += "file://0005-Removed-pwd-from-LD_RUN_PATH-definition.patch"

PARALLEL_MAKE = ""

#PNBLACKLIST[libtecla] ?= "Stopped building around April 2017"
