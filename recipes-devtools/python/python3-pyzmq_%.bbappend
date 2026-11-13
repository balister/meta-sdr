# pyzmq's CMakeLists.txt appends the host's /usr to CMAKE_PREFIX_PATH, and
# pkg_check_modules() turns that into PKG_CONFIG_PATH=/usr/lib64/pkgconfig:...,
# which pkg-config searches before the sysroot. On a host with zeromq-devel
# installed (Fedora's libzmq.pc adds -DZMQ_BUILD_DRAFT_API=1), pyzmq gets built
# against the draft API and fails to import on the target with
# "undefined symbol: zmq_poller_destroy". Stop CMake adding its prefix paths
# to the pkg-config search path so only the sysroot is used.
PEP517_BUILD_OPTS:append = " -Ccmake.define.PKG_CONFIG_USE_CMAKE_PREFIX_PATH=OFF"
