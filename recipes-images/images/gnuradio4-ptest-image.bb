SUMMARY = "An image to help build test gnuradio4 recipes"

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   allow-empty-password empty-root-password \
                   allow-root-login post-install-logging \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    gnuradio4-incubator \
    gnuradio4-control-plane \
    gnuradio4-core-ptest \
    ptest-runner \
    "

SDK_NAME = "${BPN}-${MACHINE}"

inherit core-image image-buildinfo
