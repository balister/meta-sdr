require gnuradio-dev-image.bb

IMAGE_FEATURES += "x11-base "

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-sdr-gnuradio-extended \
    xinput-calibrator \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'xserver-xorg-extension-glx', '', d)} \
    directfb-examples \
    wpa-supplicant \
    hostapd \
    dnsmasq \
    lighttpd \
    lighttpd-module-cgi \
    python3-pyephem \
    gqrx \
    "
