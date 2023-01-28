# packagegroup definitions to help the SDR community build images
# they like. Note packagegrou-sdr-base doesn't actually build any sdr apps.

LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-base-debug \
    packagegroup-sdr-base-devel \
    packagegroup-sdr-base-python \
"

PROVIDES = "${PACKAGES}"

SUMMARY:packagegroup-sdr-base-extended = "Basic packages for an image with regular unix utilities."
RDEPENDS:packagegroup-sdr-base-extended = "\
    alsa-utils \
    i2c-tools \
    screen \
    vim \
    vim-vimrc \
    htop \
    iw \
    sshfs-fuse \
    libudev \
    ${@bb.utils.contains('ENABLE_WIDEC', 'false', '', 'nano', d)}  \
    nfs-utils-client \
    cifs-utils \
    ${@bb.utils.contains('IMAGE_FEATURES', 'ssh-server-openssh', 'openssh-sftp openssh-sftp-server', '', d)} \
    procps \
    protobuf \
    ntp \
    ntpdate \
    ntp-utils \
    libsodium \
    sqlite3 \
    tar \
    wget \
    zip \
    unzip \
    rsync \
"

SUMMARY:packagegroup-sdr-base-debug = "Debugging tools."
RDEPENDS:packagegroup-sdr-base-debug = "\
    evtest \
    devmem2 \
    iperf3 \
    tcpdump \
"

# Also set the image feature dev-pkgs, tools-sdk, and tools-debug
# for a sane development image.
SUMMARY:packagegroup-sdr-base-devel = "Development tools."
RDEPENDS:packagegroup-sdr-base-devel = "\
    git \
    git-perltools \
    swig \
    boost \
    cmake \
    orc \
    libudev \
    glib-2.0 \
"

SUMMARY:packagegroup-sdr-base-python = "Basic python packages."
RDEPENDS:packagegroup-sdr-base-python = "\
    python3 \
    python3-distutils-extra \
    python3-pip \
    python3-mako \
    python3-pyyaml \
"
