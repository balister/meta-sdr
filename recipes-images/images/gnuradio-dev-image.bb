DESCRIPTION = "A console-only image with a development/debug \
environment suitable for building GNURadio installed."

IMAGE_FEATURES += "splash ssh-server-openssh tools-sdk \
                   tools-debug debug-tweaks \
                   dev-pkgs dbg-pkgs \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

TOOLCHAIN_HOST_TASK_append = " nativesdk-python-cheetah \
    nativesdk-python-netserver nativesdk-python-pprint \
    nativesdk-python-pickle nativesdk-python-shell \
    nativesdk-orc nativesdk-swig nativesdk-python-distutils \
    nativesdk-python-xml nativesdk-python-compile \
    nativesdk-python-subprocess nativesdk-python-threading \
    nativesdk-python-dev nativesdk-git nativesdk-mcpp \
    nativesdk-db \
    "

CORE_IMAGE_EXTRA_INSTALL = "\
    gnuradio \
    db-dev \
    mcpp \
    bzip2 \
    openssl-dev \
    alsa-utils \
    i2c-tools \
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
    python-xml \
    htop \
    sshfs-fuse \
    glib-2.0 \
    orc \
    orc-dev \
    libudev \
    iperf \
    openssh-sftp \
    openssh-sftp-server \
    fftwf \
    "

inherit core-image
