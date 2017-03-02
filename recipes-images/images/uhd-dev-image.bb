SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio installed."

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh tools-sdk \
                   tools-debug debug-tweaks \
                   dev-pkgs \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

require recipes-images/images/native-sdk.inc

CORE_IMAGE_EXTRA_INSTALL = "\
    alsa-utils \
    i2c-tools \
    devmem2 \
    screen \
    vim \
    vim-vimrc \
    git \
    swig \
    boost \
    cmake \
    gsl \
    python \
    python-cheetah \
    python-modules \
    python-argparse \
    python-distutils \
    python-numpy \
    htop \
    sshfs-fuse \
    glib-2.0 \
    orc \
    libudev \
    iperf3 \
    openssh-sftp \
    openssh-sftp-server \
    fftwf-wisdom \
    ntpdate \
    uhd \
    uhd-examples \
    "

inherit core-image image-buildinfo
