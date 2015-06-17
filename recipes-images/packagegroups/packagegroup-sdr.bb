# packagegroup definitions to help the SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-debug \
    packagegroup-sdr-devel \
    packagegroup-sdr-python \
    packagegroup-sdr-gnuradio \
    packagegroup-sdr-hardware \
    packagegroup-sdr-uhd \
    packagegroup-sdr-rtlsdr \
    packagegroup-sdr-bladerf \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-sdr-base-extended = "Basic packages for an image with regular unix utilities."
RDEPENDS_packagegroup-sdr-base-extended = "\
    alsa-utils \
    i2c-tools \
    screen \
    vim \
    vim-vimrc \
    htop \
    sshfs-fuse \
    libudev \
    nfs-utils-client \
    openssh-sftp \
    openssh-sftp-server \
    procps \
    ntpdate \
    linux-firmware \
    resolvconf \
    sqlite3 \
    wget \
    zip \
    unzip \
"

SUMMARY_packagegroup-sdr-debug = "Debugging tools."
RDEPENDS_packagegroup-sdr-debug = "\
    evtest \
    devmem2 \
    iperf \
    tcpdump \
    valgrind \
"

# Also set the image feature dev-pkgs, tools-sdk, and tools-debug
# for a sane development image.
SUMMARY_packagegroup-sdr-devel = "Development tools."
RDEPENDS_packagegroup-sdr-devel = "\
    git \
    git-perltools \
    swig \
    boost \
    cmake \
    orc \
    libudev \
    glib-2.0 \
"

SUMMARY_packagegroup-sdr-python = "Useful python packages."
RDEPENDS_packagegroup-sdr-python = "\
    python \
    python-cheetah \
    python-modules \
    python-argparse \
    python-distutils \
    python-numpy \
    python-cython \
    python-pip \
    python-twisted \
    python-six \
"

SUMMARY_packagegroup-sdr-gnuradio = "All the GNU Radio stuff we know about."
RDEPENDS_packagegroup-sdr-gnuradio = "\
    gnuradio \
    gnuradio-dbg \
    gr-osmosdr \
    gr-eventstream \
"


SUMMARY_packagegroup-sdr-uhd = "UHD packages."
RDEPENDS_packagegroup-sdr-uhd = "\
    uhd \
    uhd-examples \
"

SUMMARY_packagegroup-sdr-rtlsdr = "RTLSDR packages."
RDEPENDS_packagegroup-sdr-rtlsdr = "\
    rtl-sdr \
"

SUMMARY_packagegroup-sdr-bladerf = "BladeRF packages."
RDEPENDS_packagegroup-sdr-bladerf = "\
    libbladerf \
    libbladerf-bin \
"

SUMMARY_packagegroup-sdr-hardware = "All supported SDR hardware."
RDEPENDS_packagegroup-sdr-hardware = "\
    packagegroup-sdr-uhd \
    packagegroup-sdr-rtlsdr \
    packagegroup-sdr-bladerf \
    gr-baz \
    gr-burst \
    gr-framers \
    gr-mac \
    gr-mapper \
    gr-message-tools \
"
