SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

CORE_IMAGE_EXTRA_INSTALL:append = "ptest-runner gnuradio-ptest volk-ptest \
                                   "

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile \
                  "

LICENSE = "MIT"

require gnuradio-image.bb

