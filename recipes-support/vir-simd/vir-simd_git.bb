# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   CODE_OF_CONDUCT.md.license
#   CONTRIBUTING.md.license
#   LICENSES/GPL-3.0-or-later.txt
#   LICENSES/LGPL-3.0-or-later.txt
#   README.md.license
#   testsuite/README.md.license
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/mattkretz/vir-simd.git;protocol=https;branch=master"

BBCLASSEXTEND = "native"

# Modify these as desired
PV = "simd+git"
SRCREV = "848c298f879c9264d500c1d4ef5ad996333f9b64"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

