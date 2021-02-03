SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

CORE_IMAGE_EXTRA_INSTALL_append = "ptest-runner gnuradio-ptest volk-ptest"

LICENSE = "MIT"

require gnuradio-image.bb

