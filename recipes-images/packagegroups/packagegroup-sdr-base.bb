# packagegroup definitions to help the SDR community build images
# they like. Note packagegrou-sdr-base doesn't actually build any sdr apps.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-base-debug \
    packagegroup-sdr-base-devel \
    packagegroup-sdr-base-python \
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
    iw \
    sshfs-fuse \
    libudev \
    nano \
    nfs-utils-client \
    openssh-sftp \
    openssh-sftp-server \
    procps \
    protobuf \
    ntp \
    ntpdate \
    ntp-utils \
    linux-firmware \
    libsodium \
    resolvconf \
    sqlite3 \
    tar \
    wget \
    zip \
    unzip \
    rsync \
"

SUMMARY_packagegroup-sdr-base-debug = "Debugging tools."
RDEPENDS_packagegroup-sdr-base-debug = "\
    evtest \
    devmem2 \
    iperf3 \
    tcpdump \
"

# Also set the image feature dev-pkgs, tools-sdk, and tools-debug
# for a sane development image.
SUMMARY_packagegroup-sdr-base-devel = "Development tools."
RDEPENDS_packagegroup-sdr-base-devel = "\
    git \
    git-perltools \
    swig \
    boost \
    cmake \
    orc \
    libudev \
    glib-2.0 \
"

SUMMARY_packagegroup-sdr-base-python = "Basic python packages."
RDEPENDS_packagegroup-sdr-base-python = "\
    python3 \
    python3-distutils \
    python3-pip \
    python3-mako \
    python3-pyyaml \
"
