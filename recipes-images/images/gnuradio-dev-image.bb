SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh tools-sdk \
                   tools-debug debug-tweaks \
                   dev-pkgs dbg-pkgs \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

require recipes-images/images/native-sdk.inc

CORE_IMAGE_EXTRA_INSTALL = "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-debug \
    packagegroup-sdr-devel \
    packagegroup-sdr-python \
    packagegroup-sdr-gnuradio \
    packagegroup-sdr-hardware \
    xauth \
    "

#    zeroc-ice 

inherit core-image
