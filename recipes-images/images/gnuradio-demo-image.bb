require gnuradio-dev-image.bb

IMAGE_FEATURES += "x11-base qt4-pkgs"

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-sdr-gnuradio-extended \
    gqrx \
    xinput-calibrator \
    mesa \
    mesa-megadriver \
    xserver-xorg-extension-glx \
    directfb-examples \
    wpa-supplicant \
    hostapd \
    dnsmasq \
    lighttpd \
    lighttpd-module-cgi \
    php \
    php-cgi \
    python-pyqt \
    "
