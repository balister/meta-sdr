SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

CORE_IMAGE_EXTRA_INSTALL_append = "ptest-runner gnuradio-ptest volk-ptest \
                                   fftw-ptest"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs \
			dbg-pkgs \
                  "

LICENSE = "MIT"

require gnuradio-image.bb

