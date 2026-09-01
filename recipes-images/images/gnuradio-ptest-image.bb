SUMMARY = "A console-only image for running gnuradio4 related ptests"

CORE_IMAGE_EXTRA_INSTALL:append = "ptest-runner gnuradio4-core-ptest \
                                   "
EXTRA_IMAGE_FEATURES += "tools-debug tools-profile \
                  "
LICENSE = "MIT"

require gnuradio4-image.bb

