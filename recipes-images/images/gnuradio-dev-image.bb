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
    nativesdk-python-xml nativesdk-python-compile"

CORE_IMAGE_EXTRA_INSTALL = "\
    gnuradio-analog \
    gnuradio-audio \
    gnuradio-blocks \
    gnuradio-channels \
    gnuradio-digital \
    gnuradio-fec \
    gnuradio-fft \
    gnuradio-filter \
    gnuradio-gr \
    gnuradio-grc \
    gnuradio-gru \
    gnuradio-gr-utils \
    gnuradio-modtool \
    gnuradio-noaa \
    gnuradio-pmt \
    gnuradio-qtgui \
    gnuradio-runtime \
    gnuradio-trellis \
    gnuradio-uhd \
    gnuradio-vocoder \
    gnuradio-volk \
    gnuradio-wavelet \
    gnuradio-examples \
    gnuradio \
    gnuradio-dev \
    gr-osmosdr \
    rtl-sdr \
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
    htop \
    sshfs-fuse \
    glib-2.0 \
    orc \
    libudev \
    iperf \
    openssh-sftp \
    openssh-sftp-server \
    fftwf \
    "

inherit core-image
