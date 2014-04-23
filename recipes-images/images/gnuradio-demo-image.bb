require gnuradio-dev-image.bb

IMAGE_FEATURES += "x11-base qt4-pkgs"

CORE_IMAGE_EXTRA_INSTALL += "\
    gqrx \
    pulseaudio-server \
    xf86-video-modesetting \
    directfb-examples \
    "
