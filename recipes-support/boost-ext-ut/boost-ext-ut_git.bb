# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/boost-ext/ut.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "59a9beba0763dbb45b3cc68e4cf484c659319a97"

# NOTE: unable to map the following CMake package dependencies: ut
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DBOOST_UT_USE_WARNINGS_AS_ERORS=OFF -DBOOST_UT_BUILD_EXAMPLES=OFF -DBOOST_UT_BUILD_TESTS=OFF"

BBCLASSEXTEND = "native"
