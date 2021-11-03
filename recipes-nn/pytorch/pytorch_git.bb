# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Tensors and Dynamic neural networks in Python with strong GPU acceleration"
HOMEPAGE = "https://pytorch.org/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   aten/src/ATen/native/quantized/cpu/qnnpack/LICENSE
#   aten/src/ATen/native/quantized/cpu/qnnpack/deps/clog/LICENSE
#   caffe2/mobile/contrib/libopencl-stub/LICENSE
#   android/libs/fbjni/LICENSE
#   third_party/python-enum/enum/LICENSE
#   third_party/nccl/nccl/LICENSE.txt
#   third_party/nccl/nccl/pkg/debian/copyright
#   third_party/googletest/LICENSE
#   third_party/googletest/googletest/LICENSE
#   third_party/googletest/googlemock/LICENSE
#   third_party/googletest/googlemock/scripts/generator/LICENSE
#   third_party/NNPACK/LICENSE
#   third_party/ideep/mkl-dnn/LICENSE
#   third_party/ideep/mkl-dnn/src/cpu/x64/jit_utils/jitprofiling/LICENSE.BSD
#   third_party/ideep/mkl-dnn/src/cpu/x64/xbyak/COPYRIGHT
#   third_party/ideep/mkl-dnn/doc/legal_information.md
#   third_party/ideep/mkl-dnn/tests/gtests/gtest/LICENSE
#   third_party/zstd/LICENSE
#   third_party/eigen/COPYING.README
#   third_party/eigen/COPYING.BSD
#   third_party/eigen/COPYING.MINPACK
#   third_party/eigen/scripts/relicense.py
#   third_party/eigen/unsupported/Eigen/src/LevenbergMarquardt/CopyrightMINPACK.txt
#   third_party/eigen/bench/btl/COPYING
#   third_party/tensorpipe/LICENSE.txt
#   third_party/tensorpipe/third_party/googletest/LICENSE
#   third_party/tensorpipe/third_party/googletest/googletest/LICENSE
#   third_party/tensorpipe/third_party/googletest/googlemock/LICENSE
#   third_party/tensorpipe/third_party/googletest/googlemock/scripts/generator/LICENSE
#   third_party/tensorpipe/third_party/libuv/LICENSE
#   third_party/tensorpipe/third_party/libuv/LICENSE-docs
#   third_party/tensorpipe/third_party/pybind11/LICENSE
#   third_party/tensorpipe/third_party/pybind11/tools/clang/LICENSE.TXT
#   third_party/tbb/LICENSE
#   third_party/onnx/LICENSE
#   third_party/onnx/third_party/pybind11/LICENSE
#   third_party/onnx/third_party/pybind11/tools/clang/LICENSE.TXT
#   third_party/miniz-2.0.8/LICENSE
#   third_party/cub/LICENSE.TXT
#   third_party/neon2sse/LICENSE
#   third_party/python-peachpy/LICENSE.rst
#   third_party/pthreadpool/LICENSE
#   third_party/protobuf/LICENSE
#   third_party/protobuf/third_party/googletest/LICENSE
#   third_party/protobuf/third_party/googletest/googletest/LICENSE
#   third_party/protobuf/third_party/googletest/googlemock/LICENSE
#   third_party/protobuf/third_party/googletest/googlemock/scripts/generator/LICENSE
#   third_party/fmt/LICENSE.rst
#   third_party/fmt/doc/python-license.txt
#   third_party/fbgemm/LICENSE
#   third_party/fbgemm/third_party/googletest/LICENSE
#   third_party/fbgemm/third_party/googletest/googletest/LICENSE
#   third_party/fbgemm/third_party/googletest/googlemock/LICENSE
#   third_party/fbgemm/third_party/googletest/googlemock/scripts/generator/LICENSE
#   third_party/fbgemm/third_party/cpuinfo/LICENSE
#   third_party/fbgemm/third_party/cpuinfo/deps/clog/LICENSE
#   third_party/fbgemm/third_party/asmjit/LICENSE.md
#   third_party/cpuinfo/LICENSE
#   third_party/cpuinfo/deps/clog/LICENSE
#   third_party/pybind11/LICENSE
#   third_party/pybind11/tools/clang/LICENSE.TXT
#   third_party/gloo/LICENSE
#   third_party/gloo/gloo/transport/uv/LICENSE.uvw
#   third_party/onnx-tensorrt/third_party/onnx/LICENSE
#   third_party/onnx-tensorrt/third_party/onnx/third_party/pybind11/LICENSE
#   third_party/onnx-tensorrt/third_party/onnx/third_party/pybind11/tools/clang/LICENSE.TXT
#   third_party/sleef/LICENSE.txt
#   third_party/ios-cmake/LICENSE
#   third_party/XNNPACK/LICENSE
#   third_party/QNNPACK/LICENSE
#   third_party/QNNPACK/deps/clog/LICENSE
# NOTE: Original package / source metadata indicates license is: BSD
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "Unknown & MIT & GPLv2 & GPLv3 & MPL-2.0 & LGPLv2.1 & Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91a5dfdaccf53b27488cb3a639e986d5 \
                    file://aten/src/ATen/native/quantized/cpu/qnnpack/LICENSE;md5=f1e2603190afb8bee3644e45853bd55e \
                    file://aten/src/ATen/native/quantized/cpu/qnnpack/deps/clog/LICENSE;md5=32150729bbb899c7ce46b1d9a0e2cd44 \
                    file://caffe2/mobile/contrib/libopencl-stub/LICENSE;md5=911690f51af322440237a253d695d19f \
                    file://android/libs/fbjni/LICENSE;md5=cac82e6f105a5444e031d569a75e7443 \
                    file://third_party/python-enum/enum/LICENSE;md5=0a97a53a514564c20efd7b2e8976c87e \
                    file://third_party/nccl/nccl/LICENSE.txt;md5=8f5c7009e6aee1214f33cfa2dfd737a5 \
                    file://third_party/nccl/nccl/pkg/debian/copyright;md5=8f5c7009e6aee1214f33cfa2dfd737a5 \
                    file://third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/googletest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/googletest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/googletest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://third_party/FP16/LICENSE;md5=998fb0b16ad8a4fb8bd41bf3faf2d21c \
                    file://third_party/NNPACK/LICENSE;md5=c5a9b70072d4baa29517f99984c74aeb \
                    file://third_party/ideep/LICENSE;md5=fcb77001387249feb8deb2934a2a0172 \
                    file://third_party/ideep/mkl-dnn/LICENSE;md5=c441291ac5f15bdc6b09b4cc02ece35b \
                    file://third_party/ideep/mkl-dnn/src/cpu/x64/jit_utils/jitprofiling/LICENSE.BSD;md5=e671ff178b24a95a382ba670503c66fb \
                    file://third_party/ideep/mkl-dnn/src/cpu/x64/xbyak/COPYRIGHT;md5=3b9bf048d063d54cdb28964db558bcc7 \
                    file://third_party/ideep/mkl-dnn/doc/legal_information.md;md5=19cc17769c3634e892edcb975c47d972 \
                    file://third_party/ideep/mkl-dnn/tests/gtests/gtest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/zstd/COPYING;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0 \
                    file://third_party/zstd/LICENSE;md5=c7f0b161edbe52f5f345a3d1311d0b32 \
                    file://third_party/zstd/contrib/linux-kernel/COPYING;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0 \
                    file://third_party/eigen/COPYING.README;md5=856ad513819c1eff6b536f939c1bf803 \
                    file://third_party/eigen/COPYING.BSD;md5=543367b8e11f07d353ef894f71b574a0 \
                    file://third_party/eigen/COPYING.MINPACK;md5=5fe4603e80ef7390306f51ef74449bbd \
                    file://third_party/eigen/COPYING.GPL;md5=d32239bcb673463ab874e80d47fae504 \
                    file://third_party/eigen/COPYING.MPL2;md5=815ca599c9df247a0c7f619bab123dad \
                    file://third_party/eigen/COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://third_party/eigen/scripts/relicense.py;md5=681a608931b6a61c692985e14ab17c13 \
                    file://third_party/eigen/unsupported/Eigen/src/LevenbergMarquardt/CopyrightMINPACK.txt;md5=d9ff86916e5e5a1e3d74273ff947dab7 \
                    file://third_party/eigen/bench/btl/COPYING;md5=02023a9ab7f768bfdefdb98b629bb20d \
                    file://third_party/tensorpipe/LICENSE.txt;md5=d0f8ff2d9da693b5d2d512e867f32afa \
                    file://third_party/tensorpipe/third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/tensorpipe/third_party/googletest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/tensorpipe/third_party/googletest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/tensorpipe/third_party/googletest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://third_party/tensorpipe/third_party/libuv/LICENSE;md5=a68902a430e32200263d182d44924d47 \
                    file://third_party/tensorpipe/third_party/libuv/LICENSE-docs;md5=eacc0b19e3fb8dd12d2e110b24be0452 \
                    file://third_party/tensorpipe/third_party/pybind11/LICENSE;md5=beb87117af69fd10fbf9fb14c22a2e62 \
                    file://third_party/tensorpipe/third_party/pybind11/tools/clang/LICENSE.TXT;md5=dfabea443c6c16b6321441a8c8c19705 \
                    file://third_party/tbb/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://third_party/psimd/LICENSE;md5=1a15870c3c6ac367fa27851881128c00 \
                    file://third_party/onnx/LICENSE;md5=efff5c5110f124a1e2163814067b16e7 \
                    file://third_party/onnx/third_party/pybind11/LICENSE;md5=beb87117af69fd10fbf9fb14c22a2e62 \
                    file://third_party/onnx/third_party/pybind11/tools/clang/LICENSE.TXT;md5=dfabea443c6c16b6321441a8c8c19705 \
                    file://third_party/onnx/third_party/benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://third_party/miniz-2.0.8/LICENSE;md5=292e2564dd2edd7c3ee1eb1e50480e25 \
                    file://third_party/foxi/LICENSE;md5=dde3a16df7679fcc96d9929569168642 \
                    file://third_party/cub/LICENSE.TXT;md5=20d1414b801e2a130d7d546685105508 \
                    file://third_party/python-six/LICENSE;md5=35cec5bf04dd0820d0a18533ea7c774a \
                    file://third_party/neon2sse/LICENSE;md5=b4fdfcb48f273d192333c498d75fa26f \
                    file://third_party/python-peachpy/LICENSE.rst;md5=083a76258b33cfe514a466d172aca1d6 \
                    file://third_party/FXdiv/LICENSE;md5=0c2eed7ba400a6fea8fec2a582b177e8 \
                    file://third_party/pthreadpool/LICENSE;md5=1609499688b503850848d795dce4da2d \
                    file://third_party/protobuf/LICENSE;md5=37b5762e07f0af8c74ce80a8bda4266b \
                    file://third_party/protobuf/third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/protobuf/third_party/googletest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/protobuf/third_party/googletest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/protobuf/third_party/googletest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://third_party/protobuf/third_party/benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://third_party/fmt/LICENSE.rst;md5=af88d758f75f3c5c48a967501f24384b \
                    file://third_party/fmt/doc/python-license.txt;md5=d214581529e343354f8e23025bdf582d \
                    file://third_party/fbgemm/LICENSE;md5=63f14a7a1e9169f7183d76fb16bcaa89 \
                    file://third_party/fbgemm/third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/fbgemm/third_party/googletest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/fbgemm/third_party/googletest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/fbgemm/third_party/googletest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://third_party/fbgemm/third_party/cpuinfo/LICENSE;md5=b2e3daae5c1dc01fc35b3f10a9867c29 \
                    file://third_party/fbgemm/third_party/cpuinfo/deps/clog/LICENSE;md5=32150729bbb899c7ce46b1d9a0e2cd44 \
                    file://third_party/fbgemm/third_party/asmjit/LICENSE.md;md5=3a9d013549ebbbda6f57c007cfb5a656 \
                    file://third_party/cpuinfo/LICENSE;md5=cabca80e8e4a4bbe90e9a4b4ad53f5f4 \
                    file://third_party/cpuinfo/deps/clog/LICENSE;md5=32150729bbb899c7ce46b1d9a0e2cd44 \
                    file://third_party/pybind11/LICENSE;md5=774f65abd8a7fe3124be2cdf766cd06f \
                    file://third_party/gemmlowp/gemmlowp/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://third_party/gloo/LICENSE;md5=ea1ecec5f757696cea349b925fa70342 \
                    file://third_party/gloo/gloo/transport/uv/LICENSE.uvw;md5=75598a838148e597d8f0e810a57f3855 \
                    file://third_party/onnx-tensorrt/LICENSE;md5=73b35773827cb985bfc6c085ed8d2394 \
                    file://third_party/onnx-tensorrt/third_party/onnx/LICENSE;md5=077ce3eaeaea91462d41c566300d2a02 \
                    file://third_party/onnx-tensorrt/third_party/onnx/third_party/pybind11/LICENSE;md5=9b27fac7e937323e3de9ca3a7db38e37 \
                    file://third_party/onnx-tensorrt/third_party/onnx/third_party/pybind11/tools/clang/LICENSE.TXT;md5=dfabea443c6c16b6321441a8c8c19705 \
                    file://third_party/onnx-tensorrt/third_party/onnx/third_party/benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://third_party/sleef/LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c \
                    file://third_party/ios-cmake/LICENSE;md5=c26f299370d4cfcc7e041f70ba189265 \
                    file://third_party/benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://third_party/XNNPACK/LICENSE;md5=afa8f8a91390ab659c837da57124977c \
                    file://third_party/QNNPACK/LICENSE;md5=f1e2603190afb8bee3644e45853bd55e \
                    file://third_party/QNNPACK/deps/clog/LICENSE;md5=32150729bbb899c7ce46b1d9a0e2cd44"

SRC_URI = "gitsm://github.com/balister/pytorch.git;protocol=https;branch=lts/release/1.8 \
           file://site-file.cmake \
          "

# Modify these as desired
PV = "1.8.2"
SRCREV = "e0495a7aa104471d95dc85a1b8f6473fbcc427a8"

S = "${WORKDIR}/git"

inherit python3native cmake

FULL_OPTIMIZATION = "-O3 -pipe ${DEBUG_FLAGS}"

EXTRA_OECMAKE = "-DGLIBCXX_USE_CXX11_ABI=1 -DBUILD_PYTHON=0 -DCOMPILER_WORKS=1 \
                 -DNATIVE_BUILD_DIR=${STAGING_DIR_NATIVE}/usr \
                 -DBUILD_CUSTOM_PROTOBUF=0 -DUSE_OPENMP=OFF \
                 -DUSE_XNNPACK=OFF \
                 -DCMAKE_SYSTEM_PROCESSOR=aarch64 "

DEPENDS = "fftw python3-pyyaml-native protobuf protobuf-native openblas \
           libgfortran python3-typing-extensions-native"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python3-asyncio python3-audio python3-compression python3-core python3-crypt python3-ctypes python3-datetime python3-debugger python3-difflib python3-distutils python3-doctest python3-io python3-json python3-logging python3-math python3-misc python3-multiprocessing python3-netclient python3-numbers python3-pickle python3-pprint python3-profile python3-shell python3-sqlite3 python3-stringold python3-threading python3-typing python3-unittest"

do_compile_prepend() {
	${BUILD_CC} -o ${STAGING_BINDIR_NATIVE}/mkalias ${S}/third_party/sleef/src/libm/mkalias.c
	${BUILD_CC} -o ${STAGING_BINDIR_NATIVE}/mkrename ${S}/third_party/sleef/src/libm/mkrename.c
}

do_install_append() {
	rm -rf ${D}${includedir}/pybind11
}

FILES_${PN} += "${datadir}/ATen"
INSANE_SKIP_${PN}-dev += "dev-elf ldflags"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    DLFCN
#    IPython.display
#    PIL
#    Queue
#    __main__
#    caffe.proto
#    caffe2.caffe2.fb.session.proto
#    caffe2.distributed.python
#    caffe2.proto.caffe2_pb2
#    caffe2.proto.predictor_consts_pb2
#    caffe2.python.SparseTransformer
#    caffe2.python.caffe2_pybind11_state
#    caffe2.python.caffe2_pybind11_state_gpu
#    caffe2.python.caffe2_pybind11_state_hip
#    caffe2.python.fb
#    click
#    click.testing
#    code_template
#    com.sun
#    com.sun.jna
#    com.sun.jna.platform
#    cv2
#    flake8.main
#    flask
#    future.utils
#    gloo.python
#    google.protobuf
#    google.protobuf.message
#    google.protobuf.text_format
#    hypothesis
#    hypothesis.extra
#    hypothesis.extra.numpy
#    hypothesis.strategies
#    importlib.find_loader
#    lmdb
#    matplotlib
#    matplotlib.backends.backend_agg
#    matplotlib.pyplot
#    mock
#    moviepy
#    mpi4py
#    networkx
#    numba.cuda
#    numpy
#    numpy.matlib
#    numpy.testing
#    nvd3
#    onnx
#    onnx.backend
#    onnx.backend.base
#    onnx.backend.test
#    onnx.defs
#    onnx.helper
#    onnx.numpy_helper
#    onnx.optimizer
#    onnx.shape_inference
#    onnx.utils
#    past.builtins
#    psutil
#    pycuda.autoinit
#    pycuda.driver
#    pydot
#    scipy
#    scipy.sparse
#    scipy.special
#    scipy.stats
#    setuptools
#    setuptools.command.build_ext
#    six
#    six.moves
#    six.moves.urllib.request
#    skimage.util
#    src.ATen.code_template
#    tensorboard
#    tensorboard.backend.event_processing
#    tensorboard.compat
#    tensorboard.compat.proto
#    tensorboard.compat.proto.attr_value_pb2
#    tensorboard.compat.proto.config_pb2
#    tensorboard.compat.proto.event_pb2
#    tensorboard.compat.proto.graph_pb2
#    tensorboard.compat.proto.node_def_pb2
#    tensorboard.compat.proto.step_stats_pb2
#    tensorboard.compat.proto.summary_pb2
#    tensorboard.compat.proto.tensor_pb2
#    tensorboard.compat.proto.tensor_shape_pb2
#    tensorboard.compat.proto.versions_pb2
#    tensorboard.plugins.custom_scalar
#    tensorboard.plugins.hparams.api_pb2
#    tensorboard.plugins.hparams.metadata
#    tensorboard.plugins.hparams.plugin_data_pb2
#    tensorboard.plugins.mesh
#    tensorboard.plugins.mesh.plugin_data_pb2
#    tensorboard.plugins.pr_curve.plugin_data_pb2
#    tensorboard.plugins.projector.projector_config_pb2
#    tensorboard.plugins.text.plugin_data_pb2
#    tensorboard.summary.writer.event_file_writer
#    tensorboard.summary.writer.record_writer
#    tensorflow
#    tensorflow.core.framework
#    tensorflow.core.framework.graph_pb2
#    tensorflow.core.framework.summary_pb2
#    tensorflow.core.util
#    tensorflow.core.util.event_pb2
#    tensorflow.python.summary.writer.writer
#    tensorflow.summary
#    tensorflow.train
#    tensorrt
#    tools.shared.cwrap_common
#    torch._C
#    torch._C._VariableFunctions
#    torch._C._jit_tree_views
#    torch._dl
#    torch.for_onnx.onnx
#    torch.version
#    torchvision.models
#    tornado.httpserver
#    tornado.wsgi
#    tqdm
#    tqdm.auto
#    typing_extensions
#    urllib2
#    urlparse
#    win32api
#    win32com.shell
#    winreg
#    xmlrunner
#    yaml
