require gnuradio-dev-image.bb

IMAGE_FEATURES += "x11-base "

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-sdr-gnuradio-extended \
    xinput-calibrator \
    xserver-xorg-extension-glx \
    directfb-examples \
    wpa-supplicant \
    hostapd \
    dnsmasq \
    lighttpd \
    lighttpd-module-cgi \
    python-pyqt5 \
    python-txws \
    python-pyephem \
    "
