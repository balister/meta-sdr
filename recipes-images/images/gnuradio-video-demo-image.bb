# To build this image add:
# PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
# PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
# LICENSE_FLAGS_WHITELIST = "commercial"
# to your local.conf file. If you ship anyhting based on the recipe
# spend some time understanding the licensing issues for codecs


require gnuradio-demo-image.bb

IMAGE_FEATURES += "x11-base qt4-pkgs"

CORE_IMAGE_EXTRA_INSTALL += "\
    yavta \
    vlc \
    "
