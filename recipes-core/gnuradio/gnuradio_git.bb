SUMMARY = "GNU Radio: A software defined radio framework."
URL = "http://gnuradio.org"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "volk gsl fftw python3 python3-six-native alsa-lib boost \
           python3-pybind11-native python3-numpy python3-numpy-native spdlog \
           python3-mako-native git-native gmp libsndfile1 \
           python3-packaging-native"

#Available PACKAGECONFIG options are qtgui5 grc uhd logging orc ctrlport zeromq staticlibs
PACKAGECONFIG ??= "qtgui5 grc zeromq"

PACKAGECONFIG[qtgui5] = "-DENABLE_GR_QTGUI=ON \
                 ,-DENABLE_GR_QTGUI=OFF,qtbase qwt-qt5 python3-pyqt5 "
PACKAGECONFIG[grc] = "-DENABLE_GRC=ON,-DENABLE_GRC=OFF, , "
PACKAGECONFIG[uhd] = "-DENABLE_GR_UHD=ON,-DENABLE_GR_UHD=OFF,uhd,"
PACKAGECONFIG[logging] = "-DENABLE_GR_LOG=ON,-DENABLE_GR_LOG=OFF,log4cpp, "
PACKAGECONFIG[orc] = "-DENABLE_ORC=ON,-DENABLE_ORC=OFF,orc, "
PACKAGECONFIG[ctrlport] = "-DENABLE_GR_CTRLPORT=ON,-DENABLE_GR_CTRLPORT=OFF,thrift thrift-native, "
PACKAGECONFIG[zeromq] = "-DENABLE_GR_ZEROMQ=ON,-DENABLE_GR_ZEROMQ=OFF,cppzmq python3-pyzmq, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

inherit setuptools3-base cmake pkgconfig python3native mime mime-xdg ptest
inherit ${@bb.utils.contains('PACKAGECONFIG', 'qtgui5',' cmake_qt5', '', d)}

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

RDEPENDS:${PN} = "python3-core python3-audio python3-threading python3-codecs \
                  python3-shell python3-pickle \
                  python3-pkgutil python3-pydoc python3-mmap \
                  python3-netclient python3-difflib \
                  python3-pprint python3-numpy  \
"
RRECOMMENDS:${PN} = "${GR_PACKAGES}"

RDEPENDS:${PN}-grc = "python3-mako python3-pyyaml python3-pygobject gtk+3 cairo adwaita-icon-theme"

RDEPENDS:${PN}-qtgui = "python3-pyqt5 python3-sip3"

RDEPENDS:${PN}-zeromq = "python3-pyzmq"

C_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

#do_configure:prepend() {
#    ${BUILD_CC} ${S}/gr-vocoder/lib/codec2/generate_codebook.c -o ${S}/gr-vocoder/lib/generate_codebook -lm
#    echo "ADD_EXECUTABLE(generate_codebook IMPORTED)" >${S}/gr-vocoder/lib/generate_codebook.txt
#    echo "SET_PROPERTY(TARGET generate_codebook APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)" >>${S}/gr-vocoder/lib/generate_codebook.txt
#    echo 'SET_TARGET_PROPERTIES(generate_codebook PROPERTIES IMPORTED_LOCATION_RELEASE "${S}/gr-vocoder/lib/generate_codebook")' >>${S}/gr-vocoder/lib/generate_codebook.txt
#}

#do_compile:prepend() {
#    cp ${S}/gr-vocoder/lib/codec2/defines.h ${B}/gr-vocoder/lib/codec2
#}

ALLOW_EMPTY:${PN} = "1"

GR_PACKAGES = "gnuradio-analog gnuradio-audio gnuradio-blocks \
            gnuradio-channels gnuradio-ctrlport gnuradio-digital gnuradio-fec gnuradio-fft \
            gnuradio-filter gnuradio-gr gnuradio-gru \
            gnuradio-gr-utils \
            gnuradio-modtool gnuradio-noaa gnuradio-pager gnuradio-pmt \
            gnuradio-runtime \
            gnuradio-trellis gnuradio-uhd gnuradio-vocoder \
            gnuradio-volk gnuradio-volk-modtool gnuradio-wavelet \
            gnuradio-examples \
            gnuradio-doc gnuradio-zeromq \
            "
GR_PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'gnuradio-ptest', '', d)}"
GR_PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'qtgui4', 'gnuradio-qtgui', '', d)}"
GR_PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'qtgui5', 'gnuradio-qtgui', '', d)}"
GR_PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'grc', 'gnuradio-grc', '', d)}"

PACKAGES = "gnuradio-dbg gnuradio-staticdev gnuradio-dev ${GR_PACKAGES} gnuradio"

FILES:${PN}-analog = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/analog \
                      ${datadir}/gnuradio/analog"
FILES:${PN}-audio = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/audio \
                     ${datadir}/gnuradio/audio \
                     ${sysconfdir}/gnuradio/conf.d/gr-audio* "
FILES:${PN}-blocks = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/blocks \
                      ${datadir}/gnuradio/blocks"
FILES:${PN}-channels = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/channels \
                        ${datadir}/gnuradio/channels"
FILES:${PN}-ctrlport = "${sysconfdir}/gnuradio/conf.d/ctrlport.conf.example"
FILES:${PN}-digital = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/digital \
                       ${datadir}/gnuradio/digital"
FILES:${PN}-fec = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/fec \
                   ${datadir}/gnuradio/fec"
FILES:${PN}-fft = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/fft \
                   ${datadir}/gnuradio/fft"
FILES:${PN}-filter = "${bindir}/gr_filter_design \
                      ${PYTHON_SITEPACKAGES_DIR}/gnuradio/filter \
                      ${datadir}/gnuradio/filter"
FILES:${PN}-gr = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/gr \
                  ${datadir}/gnuradio/gr"
FILES:${PN}-grc = "${bindir}/gnuradio-companion ${datadir}/gnuradio/grc \
                   ${PYTHON_SITEPACKAGES_DIR}/gnuradio/grc \
                   ${PYTHON_SITEPACKAGES_DIR}/grc_gnuradio \
                   ${sysconfdir}/gnuradio/conf.d/grc.conf \
                   ${datadir}/icons ${datadir}/mime ${datadir}/metainfo"
FILES:${PN}-gru = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/gru \
                   ${datadir}/gnuradio/gru"
FILES:${PN}-gr-utils = "${bindir}/gr_plot* ${bindir}/grcc \
                        ${bindir}/gr_read_file_metadata \
                        ${PYTHON_SITEPACKAGES_DIR}/gnuradio/plot_data* \
                        ${PYTHON_SITEPACKAGES_DIR}/gnuradio/plot_fft_base* \
                        ${PYTHON_SITEPACKAGES_DIR}/gnuradio/plot_psd_base* \
                        ${PYTHON_SITEPACKAGES_DIR}/gnuradio/pyqt_filter* \
                        ${PYTHON_SITEPACKAGES_DIR}/gnuradio/pyqt_plot*"
FILES:${PN}-modtool = "${bindir}/gr_modtool ${datadir}/gnuradio/modtool \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/modtool \
                       ${sysconfdir}/gnuradio/conf.d/modtool.conf"
FILES:${PN}-noaa = "${datadir}/gnuradio/noaa \
                    ${PYTHON_SITEPACKAGES_DIR}/gnuradio/noaa"
FILES:${PN}-pager = "${bindir}/usrp_flex* \
                     ${datadir}/gnuradio/pager \
                     ${PYTHON_SITEPACKAGES_DIR}/gnuradio/pager"
FILES:${PN}-pmt = "${datadir}/pmt \
                   ${PYTHON_SITEPACKAGES_DIR}/pmt"
FILES:${PN}-qtgui = "${bindir}/gr_psd_plot* ${bindir}/gr_spectrogram_plot* \
                     ${bindir}/gr_time* ${bindir}/gr_constellation_plot \
                     ${sysconfdir}/gnuradio/qtgui ${sysconfdir}/gnuradio/conf.d/gr-qtgui.conf \
                     ${PYTHON_SITEPACKAGES_DIR}/gnuradio/qtgui \
                     ${datadir}/gnuradio/themes"
FILES:${PN}-runtime = "${sysconfdir}/gnuradio/conf.d/gnuradio-runtime.conf \
                       ${bindir}/gnuradio-config-info \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/eng_* \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/__init__* \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/gr_unittest* \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/gr_xmlrunner* \
                      "
FILES:${PN}-trellis = "${datadir}/gnuradio/trellis \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/trellis"
FILES:${PN}-uhd = "${bindir}/uhd* \
                   ${datadir}/gnuradio/uhd \
                   ${PYTHON_SITEPACKAGES_DIR}/gnuradio/uhd"
FILES:${PN}-vocoder = "${datadir}/gnuradio/vocoder \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/vocoder"
FILES:${PN}-zeromq = "${datadir}/gnuradio/zeromq \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/zeromq"
FILES:${PN}-volk = "${bindir}/volk_profile ${bindir}/volk-config-info"
FILES:${PN}-volk-modtool = "${bindir}/volk_modtool \
                       ${PYTHON_SITEPACKAGES_DIR}/volk_modtool"
FILES:${PN}-wavelet = "${datadir}/gnuradio/wavelet \
                       ${PYTHON_SITEPACKAGES_DIR}/gnuradio/wavelet"
FILES:${PN}-examples = "${datadir}/gnuradio/examples"

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/gnuradio"
FILES:${PN} += "${sysconfdir}/gnuradio"
FILES:${PN}-dev += "${libdir}/cmake"
FILES:${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/gnuradio/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/gnuradio/*/.debug \
                    ${datadir}/gnuradio/examples/*/.debug \
"

python populate_packages:prepend() {
    gnuradio_libdir = d.expand('${libdir}')
    gnuradio_pkgconfig = d.expand('${libdir}/pkgconfig')

    # Runtime package
#     do_split_packages(d, gnuradio_libdir, '^lib(.*)\.so',
#                       output_pattern='lib%s',
#                       description='gnuradio %s library',
#                       extra_depends='',
#                       prepend=True,
#                       allow_links=True)
#
#     # Development packages (-dev)
#     pkgs=do_split_packages(d, gnuradio_libdir, '^lib([a-z]*\-[a-z]*)(?:|\-3\.7\.10\.2)\.so$',
#                       output_pattern='lib%s-dev',
#                       description='gnuradio %s development package',
#                       extra_depends='${PN}-dev',
#                       prepend=True,
#                       allow_links=True)
#     do_split_packages(d, gnuradio_libdir, '^lib(.*)\.so',
#                       output_pattern='lib%s',
#                       description='gnuradio %s library',
#                       extra_depends='',
#                       prepend=True,
#                       allow_links=True)

    #Runtime package
    do_split_packages(d, gnuradio_libdir, '^lib([a-z]*\-[a-z]*)\-.*\.so\.0.*',
                      output_pattern='lib%s',
                      description='gnuradio %s library',
                      extra_depends='',
                      prepend=True,
                      allow_links=True)
    #Development packages (-dev)
    pkgs=[]
    pkgs+=do_split_packages(d, gnuradio_libdir, '^lib([a-z]*\-[a-z]*).*\.so$',
                      output_pattern='lib%s-dev',
                      description='gnuradio %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)
    pkgs+=do_split_packages(d, gnuradio_libdir, '^lib([a-z]*\-[a-z]*)\.so$',
                      output_pattern='lib%s-dev',
                      description='gnuradio %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)

    #do_split_packages(d, gnuradio_pkgconfig, '^lib(.*)\.pc$',
    #                  output_pattern='lib%s-dev',
    #                  description='gnuradio %s development package',
     #                 extra_depends='${PN}-dev',
     #                 prepend=True)
    pn = d.getVar('PN')
    if pkgs:
        d.appendVar('RDEPENDS:'+pn+'-dev', ' '+' '.join(pkgs))
}

#PV = "3.10.4.0+git${SRCPV}"
PV = "v3.10.5.0-rc1"

FILESPATHPKG:prepend = "gnuradio-git:"

SRCREV ="44388c66cd545320a34bc89a381c13c74d23abad"

# Make it easy to test against branches
GIT_BRANCH = "maint-3.10"
GITHUB_USER = "gnuradio"

SRC_URI = "git://github.com/${GITHUB_USER}/gnuradio.git;branch=${GIT_BRANCH};protocol=https \
           file://run-ptest \
          "

S="${WORKDIR}/git"

EXTRA_OECMAKE = "\
                 -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
                 -DENABLE_GR_ATSC=FALSE \
                 -DENABLE_GR_FCD=OFF \
                 -DENABLE_GR_WXGUI=OFF \
                 -DENABLE_GR_VIDEO_SDL=OFF \
                 -DENABLE_GR_DTV=OFF \
                 -DENABLE_SPHINX=OFF -DENABLE_DOXYGEN=OFF \
                 -DENABLE_ORC=OFF \
                 -DENABLE_GR_VOCODER=OFF \
                 -DENABLE_INTERNAL_VOLK=OFF \
                 ${@bb.utils.contains('TUNE_FEATURES', 'neon', \
                     '-Dhave_mfpu_neon=1', '-Dhave_mfpu_neon=0', d)} \
"

do_install_ptest() {
    mkdir -p ${D}${PTEST_PATH}
    cd ${B}
    find . -name "qa*sh" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name test_modtool_test.sh -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name "CTestTestfile.cmake" -exec cp --parents {} ${D}${PTEST_PATH} \;

    cd ${S}
    find . -name "qa*py" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name "_qa*py" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name "*.alist" -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name file_taps_loader.py -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name test_16bit_1chunk.wav -exec cp --parents {} ${D}${PTEST_PATH} \;
    find . -name test_modtool.py -exec cp --parents {} ${D}${PTEST_PATH} \;
}
