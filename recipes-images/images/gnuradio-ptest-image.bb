SUMMARY = "A console-only image for running gnuradio4 related ptests"

CORE_IMAGE_EXTRA_INSTALL:append = " ptest-runner gnuradio-ptest \
                                   "
EXTRA_IMAGE_FEATURES:append = " tools-debug tools-profile \
                  "
LICENSE = "MIT"

require gnuradio-image.bb

