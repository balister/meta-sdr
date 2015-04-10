# To build this image add:
# PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
# PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
# LICENSE_FLAGS_WHITELIST = "commercial"
# to your local.conf file. If you ship anything based on the recipe
# spend some time understanding the licensing issues for codecs
# You will also need to add the following layers to your bblayers conf file
# meta-multimedia
# meta-gnome

require gnuradio-demo-image.bb

IMAGE_FEATURES += "x11-base qt4-pkgs"

CORE_IMAGE_EXTRA_INSTALL += "\
    opencv \
    yavta \
    vlc \
    libv4l \
    libavcodec54 \
    "
