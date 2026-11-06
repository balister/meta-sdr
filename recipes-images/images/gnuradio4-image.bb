SUMMARY = "An image to run gnuradio4 headless, with a remote gr4-studio"

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   allow-empty-password empty-root-password \
                   allow-root-login post-install-logging \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    gnuradio4-control-plane \
    gnuradio4-blocks \
    gnuradio4-studio-blocks \
    soapyrtlsdr \
    rtl-sdr-bin \
    "

SDK_NAME = "${BPN}-${MACHINE}"

inherit core-image image-buildinfo
