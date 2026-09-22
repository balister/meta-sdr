SUMMARY = "Browser and desktop Studio environment for GNU Radio 4"
HOMEPAGE = "https://github.com/gnuradio/gnuradio4-studio"

# NOTE: multiple licenses have been detected; they have been separated with AND
# in the LICENSE value since it is a reasonable assumption that all of the
# licenses apply. If instead there is a choice between the multiple licenses
# then you should change the value to separate the licenses with OR instead
# of AND. If there is any doubt, check the accompanying documentation to
# determine which situation is applicable.
#
# recipetool couldn't match these packages' LICENSE files to its hash
# database (each carries a non-standard extra heading, e.g. rollup's and
# vite's own "# Rollup/Vite core license" line before the normal MIT text)
# and left them "Unknown"; identified by hand by reading each file directly:
#   node_modules/@rolldown/pluginutils/LICENSE  -> MIT
#   node_modules/caniuse-lite/LICENSE           -> CC-BY-4.0
#   node_modules/didyoumean/LICENSE             -> Apache-2.0
#   node_modules/json5/LICENSE.md               -> MIT
#   node_modules/rollup/LICENSE.md              -> MIT
#   node_modules/source-map-js/LICENSE          -> BSD-3-Clause
#   node_modules/vite/LICENSE.md                -> MIT
#   (plus several nested node_modules/*/LICENSE, see LICENSE:${PN}-* below)
LICENSE = "0BSD AND Apache-2.0 AND BSD-3-Clause AND CC-BY-4.0 AND GPL-3.0-only AND ISC AND MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504 \
                    file://blocks/LICENSE;md5=dca174369926f2d6038aaf9ee5698d26 \
                    file://node_modules/@alloc/quick-lru/license;md5=915042b5df33c31a6db2b37eadaa00e3 \
                    file://node_modules/@babel/code-frame/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/compat-data/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/core/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/generator/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-compilation-targets/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-globals/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-module-imports/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-module-transforms/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-plugin-utils/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-string-parser/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-validator-identifier/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helper-validator-option/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/helpers/LICENSE;md5=9303635d34a07d5da57993879f5dbe71 \
                    file://node_modules/@babel/parser/LICENSE;md5=3b324af8e79986f4a5621efa85dd1292 \
                    file://node_modules/@babel/plugin-transform-react-jsx-self/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/plugin-transform-react-jsx-source/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/template/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/traverse/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@babel/types/LICENSE;md5=b1d0cd283a346e919abb3beeb018279d \
                    file://node_modules/@dnd-kit/accessibility/LICENSE;md5=e31a7689426b1a30e8d56b5941af88b7 \
                    file://node_modules/@dnd-kit/core/LICENSE;md5=e31a7689426b1a30e8d56b5941af88b7 \
                    file://node_modules/@dnd-kit/utilities/LICENSE;md5=e31a7689426b1a30e8d56b5941af88b7 \
                    file://node_modules/@jridgewell/gen-mapping/LICENSE;md5=2327dcc62ba928de8438ea5881779911 \
                    file://node_modules/@jridgewell/remapping/LICENSE;md5=2327dcc62ba928de8438ea5881779911 \
                    file://node_modules/@jridgewell/resolve-uri/LICENSE;md5=5e5f6ed6b602bd248e3493f8c6719a4b \
                    file://node_modules/@jridgewell/sourcemap-codec/LICENSE;md5=2327dcc62ba928de8438ea5881779911 \
                    file://node_modules/@jridgewell/trace-mapping/LICENSE;md5=2327dcc62ba928de8438ea5881779911 \
                    file://node_modules/@nodelib/fs.scandir/LICENSE;md5=580f1c3c6765fecfdb93bdf4e068d952 \
                    file://node_modules/@nodelib/fs.stat/LICENSE;md5=580f1c3c6765fecfdb93bdf4e068d952 \
                    file://node_modules/@nodelib/fs.walk/LICENSE;md5=580f1c3c6765fecfdb93bdf4e068d952 \
                    file://node_modules/@rolldown/pluginutils/LICENSE;md5=fe169b73800af45d7978b9d7de92efa6 \
                    file://node_modules/@tanstack/query-core/LICENSE;md5=762652b6bdba9880d64b21a1dc35738a \
                    file://node_modules/@tanstack/react-query/LICENSE;md5=762652b6bdba9880d64b21a1dc35738a \
                    file://node_modules/@types/babel__core/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/babel__generator/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/babel__template/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/babel__traverse/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-color/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-drag/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-interpolate/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-selection/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-transition/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/d3-zoom/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@types/estree/LICENSE;md5=d4a904ca135bb7bc912156fee12726f0 \
                    file://node_modules/@vitejs/plugin-react/LICENSE;md5=a7c86adeebc96d84c68400ecf10eb9bd \
                    file://node_modules/@xyflow/react/LICENSE;md5=39b461ad86761c91d173a288d3a06c8a \
                    file://node_modules/@xyflow/react/node_modules/zustand/LICENSE;md5=bbf6667cf6460b01c7611dc0011e80bd \
                    file://node_modules/@xyflow/system/LICENSE;md5=39b461ad86761c91d173a288d3a06c8a \
                    file://node_modules/any-promise/LICENSE;md5=23f6397c804f5b7ff94d956a67f2c8fb \
                    file://node_modules/anymatch/LICENSE;md5=12cd52ddd05803f07238d49743e68e37 \
                    file://node_modules/arg/LICENSE.md;md5=97dedb63665ebc6149559d7251c36a74 \
                    file://node_modules/autoprefixer/LICENSE;md5=d13bcc36e1c677587e79407275ee2702 \
                    file://node_modules/baseline-browser-mapping/LICENSE.txt;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://node_modules/binary-extensions/license;md5=6c593968ebdd2bea3d4492d893155c74 \
                    file://node_modules/braces/LICENSE;md5=0f64900f8f30e53054962c9f1fc3205b \
                    file://node_modules/browserslist/LICENSE;md5=682c6ecefabf029421a73d536b01288a \
                    file://node_modules/camelcase-css/license;md5=5ba26d44d4c5ba2e3793cdbb0f388303 \
                    file://node_modules/caniuse-lite/LICENSE;md5=60f8103054954b2c75f1faa295ea3590 \
                    file://node_modules/chokidar/LICENSE;md5=385493bcd68524333269db742d243165 \
                    file://node_modules/chokidar/node_modules/glob-parent/LICENSE;md5=a3d42bb676c62db87cbf7b04d98da83e \
                    file://node_modules/classcat/LICENSE.md;md5=e45dd216c3fe7c3ca8f67f20bcd5dadc \
                    file://node_modules/commander/LICENSE;md5=25851d4d10d6611a12d5571dab945a00 \
                    file://node_modules/convert-source-map/LICENSE;md5=bf595075ff556bc46c43e08f142fa4f5 \
                    file://node_modules/cookie/LICENSE;md5=bc85b43b6f963e8ab3f88e63628448ca \
                    file://node_modules/cssesc/LICENSE-MIT.txt;md5=ee9bd8b835cfcd512dd644540dd96987 \
                    file://node_modules/d3-color/LICENSE;md5=a23f7de4a30c522792608a1cb73836c8 \
                    file://node_modules/d3-dispatch/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-drag/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-ease/LICENSE;md5=4beaa7ba8852c6030cf1c193ea7d6f18 \
                    file://node_modules/d3-interpolate/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-selection/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-timer/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-transition/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/d3-zoom/LICENSE;md5=bd18a9b972cd2b43fca5be7c3d6642be \
                    file://node_modules/debug/LICENSE;md5=d85a365580888e9ee0a01fb53e8e9bf0 \
                    file://node_modules/didyoumean/LICENSE;md5=6d699216089e2776385e21ed5828c5a1 \
                    file://node_modules/electron-to-chromium/LICENSE;md5=c4bd4cd0c32203ba1496aa7686422491 \
                    file://node_modules/es-errors/LICENSE;md5=8fe23ea421aaf9f9d687709f6a6a09b7 \
                    file://node_modules/esbuild/LICENSE.md;md5=46b907b175628fe6d2a5258b252970fa \
                    file://node_modules/escalade/license;md5=1cb46128f91146188c0ded3a1c6144f3 \
                    file://node_modules/fast-glob/LICENSE;md5=580f1c3c6765fecfdb93bdf4e068d952 \
                    file://node_modules/fast-glob/node_modules/glob-parent/LICENSE;md5=a3d42bb676c62db87cbf7b04d98da83e \
                    file://node_modules/fastq/LICENSE;md5=78523ef0bd3eb9fefc799bbe84780631 \
                    file://node_modules/fill-range/LICENSE;md5=0f64900f8f30e53054962c9f1fc3205b \
                    file://node_modules/fraction.js/LICENSE;md5=91aeefa70be6e73eb6a047cbf06392fb \
                    file://node_modules/function-bind/LICENSE;md5=e7417c1a8ad83f88bcac21ad440d48b2 \
                    file://node_modules/gensync/LICENSE;md5=4edef26a9728782f6e6a4ca612cfc1fb \
                    file://node_modules/glob-parent/LICENSE;md5=741e38024be3bd65f6d836f460f4445f \
                    file://node_modules/hasown/LICENSE;md5=19283ee92f78c91154834571c1f05a94 \
                    file://node_modules/is-binary-path/license;md5=da0684b7c90dcea9333d6517f4fbda22 \
                    file://node_modules/is-core-module/LICENSE;md5=02b0fb5ff4014a08fd4193bc3e2349e2 \
                    file://node_modules/is-extglob/LICENSE;md5=97b255bb4707da164bfaf4e5c7b9f9ef \
                    file://node_modules/is-glob/LICENSE;md5=3d83ea4c8ec9b31d9ff2c82fa29beabb \
                    file://node_modules/is-number/LICENSE;md5=0f64900f8f30e53054962c9f1fc3205b \
                    file://node_modules/jiti/LICENSE;md5=acc13761f32b1345cfb5f817b0c140c0 \
                    file://node_modules/js-tokens/LICENSE;md5=1d63bea73a26ffaf5e964ce74d3b83a5 \
                    file://node_modules/jsesc/LICENSE-MIT.txt;md5=ee9bd8b835cfcd512dd644540dd96987 \
                    file://node_modules/json5/LICENSE.md;md5=d80f2808a405d641840b50a06f80e93c \
                    file://node_modules/lilconfig/LICENSE;md5=6e48c9ec6d16d907e6ac4c6a41491f3e \
                    file://node_modules/lines-and-columns/LICENSE;md5=ccca5bd3aeb53dd27037cf30f01b379f \
                    file://node_modules/loose-envify/LICENSE;md5=32e26a5793a4ffbace6131bc51567cb8 \
                    file://node_modules/lru-cache/LICENSE;md5=82703a69f6d7411dde679954c2fd9dca \
                    file://node_modules/merge2/LICENSE;md5=d8aa1e0b760adbfc8e07a9a6eb24a60e \
                    file://node_modules/micromatch/LICENSE;md5=0f64900f8f30e53054962c9f1fc3205b \
                    file://node_modules/ms/license.md;md5=2b8bc52ae6b7ba58e1629deabd53986f \
                    file://node_modules/mz/LICENSE;md5=e2282a6fe0850af43b9212b1081ea938 \
                    file://node_modules/nanoid/LICENSE;md5=237c21016e56a1ee4475a39fc00d1504 \
                    file://node_modules/node-releases/LICENSE;md5=9201369490251e1be377462bd41f58eb \
                    file://node_modules/normalize-path/LICENSE;md5=ccdc0959f67943eb090f7e7c299621af \
                    file://node_modules/object-assign/license;md5=a12ebca0510a773644101a99a867d210 \
                    file://node_modules/object-hash/LICENSE;md5=5cdb72856f26dc0bd5700bad915275c0 \
                    file://node_modules/path-parse/LICENSE;md5=4b940f9668dfcb796d2cb98ad94692df \
                    file://node_modules/picocolors/LICENSE;md5=efe274148be031a1fbdaf790e245552b \
                    file://node_modules/picomatch/LICENSE;md5=abd0e25891525eb13d5a794f550a6ee4 \
                    file://node_modules/pirates/LICENSE;md5=d8acca882f1cd66c0dc560046cf5473f \
                    file://node_modules/postcss-import/LICENSE;md5=4d3d8465a474d3f521fb935fd939bdc0 \
                    file://node_modules/postcss-js/LICENSE;md5=8c488a178aec55680d1f24d6ce775f2a \
                    file://node_modules/postcss-load-config/LICENSE;md5=b9d3e41090cd32987c4e63dfde35d4fc \
                    file://node_modules/postcss-nested/LICENSE;md5=c1796bab92d731c3f55fd9091dda85df \
                    file://node_modules/postcss-selector-parser/LICENSE-MIT;md5=5a9c687fbbd43eb51c08313a2cbbf60d \
                    file://node_modules/postcss-value-parser/LICENSE;md5=192f05d9cfe483ed2a4511ffd5af5895 \
                    file://node_modules/postcss/LICENSE;md5=d13bcc36e1c677587e79407275ee2702 \
                    file://node_modules/queue-microtask/LICENSE;md5=fb42e5aa12bb9e365d38b4b5691d6984 \
                    file://node_modules/react-dom/LICENSE;md5=901f6cd9846257b3a9c69dbd0a49caf1 \
                    file://node_modules/react-refresh/LICENSE;md5=ae79e563b8a09c8fc37978f18dbaa640 \
                    file://node_modules/react-resizable-panels/LICENSE.md;md5=9deade30d1269c06edd1fbf4496be42e \
                    file://node_modules/react-router-dom/LICENSE.md;md5=4871ae884c1a5b4307340c3c723b3c78 \
                    file://node_modules/react-router/LICENSE.md;md5=4871ae884c1a5b4307340c3c723b3c78 \
                    file://node_modules/react/LICENSE;md5=901f6cd9846257b3a9c69dbd0a49caf1 \
                    file://node_modules/read-cache/LICENSE;md5=ac58a2a76f8e7bcab9912d4d52c89879 \
                    file://node_modules/readdirp/LICENSE;md5=d982124c58b759403329f9c0906aae7a \
                    file://node_modules/resolve/LICENSE;md5=baa47288b5bd3e657a01886ce3dd0cb6 \
                    file://node_modules/reusify/LICENSE;md5=e0605449e69c0479b324713b257e5944 \
                    file://node_modules/rollup/LICENSE.md;md5=f52ef94c01ec29ea99e3343c2b37084b \
                    file://node_modules/run-parallel/LICENSE;md5=fb42e5aa12bb9e365d38b4b5691d6984 \
                    file://node_modules/scheduler/LICENSE;md5=901f6cd9846257b3a9c69dbd0a49caf1 \
                    file://node_modules/semver/LICENSE;md5=82703a69f6d7411dde679954c2fd9dca \
                    file://node_modules/set-cookie-parser/LICENSE;md5=ff5175cfd1ecea8070cc79951f921f96 \
                    file://node_modules/source-map-js/LICENSE;md5=b1ca6dbc0075d56cbd9931a75566cd44 \
                    file://node_modules/sucrase/LICENSE;md5=eaecbcc1b03c14c5c4cffdb8763555de \
                    file://node_modules/supports-preserve-symlinks-flag/LICENSE;md5=d237eac07663bde2409de740ba75ec97 \
                    file://node_modules/tailwindcss/LICENSE;md5=38e1dd4eb26984d63336027ded02015f \
                    file://node_modules/tailwindcss/lib/css/LICENSE;md5=d4f3d7971a121ffa801bb54ba429578d \
                    file://node_modules/tailwindcss/lib/value-parser/LICENSE;md5=192f05d9cfe483ed2a4511ffd5af5895 \
                    file://node_modules/tailwindcss/src/css/LICENSE;md5=d4f3d7971a121ffa801bb54ba429578d \
                    file://node_modules/tailwindcss/src/value-parser/LICENSE;md5=192f05d9cfe483ed2a4511ffd5af5895 \
                    file://node_modules/thenify-all/LICENSE;md5=c8d3a30332ecb31cfaf4c0a06da18f5c \
                    file://node_modules/thenify/LICENSE;md5=b79e752bbf2e31e1501baa8e445c1dcb \
                    file://node_modules/tinyglobby/LICENSE;md5=3d2948034972f6f7dcef52745be90242 \
                    file://node_modules/tinyglobby/node_modules/fdir/LICENSE;md5=7d4b8f322c8f08cad3cb115882559ed2 \
                    file://node_modules/tinyglobby/node_modules/picomatch/LICENSE;md5=abd0e25891525eb13d5a794f550a6ee4 \
                    file://node_modules/to-regex-range/LICENSE;md5=b561e0a423bedc9d9ca9c8c67d40abb9 \
                    file://node_modules/ts-interface-checker/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e \
                    file://node_modules/tslib/CopyrightNotice.txt;md5=cb391e9e435b114c07bee8f6754c4f98 \
                    file://node_modules/tslib/LICENSE.txt;md5=f938d99cba29007eeae26d80a9a4cfa6 \
                    file://node_modules/update-browserslist-db/LICENSE;md5=545bc1478a55f3ab97076edeca94a02a \
                    file://node_modules/uplot/LICENSE;md5=e6317ce4dbbe5c9f1c6946e3aba62296 \
                    file://node_modules/use-sync-external-store/LICENSE;md5=ae79e563b8a09c8fc37978f18dbaa640 \
                    file://node_modules/util-deprecate/LICENSE;md5=b7c99ef4b0f3ad9911a52219947f8cf0 \
                    file://node_modules/vite/LICENSE.md;md5=a7628cdad1e747d3b6a48699e9c43131 \
                    file://node_modules/vite/node_modules/fdir/LICENSE;md5=7d4b8f322c8f08cad3cb115882559ed2 \
                    file://node_modules/vite/node_modules/picomatch/LICENSE;md5=abd0e25891525eb13d5a794f550a6ee4 \
                    file://node_modules/yallist/LICENSE;md5=82703a69f6d7411dde679954c2fd9dca \
                    file://node_modules/zod/LICENSE;md5=8ea0b6efff8284564a5626173e81d440 \
                    file://node_modules/zustand/LICENSE;md5=bbf6667cf6460b01c7611dc0011e80bd \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COMMON_LICENSE_DIR}/CC-BY-4.0;md5=9b33bbd06fb58995fb0e299cd38d1838"

# destsuffix=${BP} on the npmsw:// entry is required (recipetool omits it):
# without it the shrinkwrap unpacks to ${UNPACKDIR} instead of ${S}, and
# npm.bbclass's do_configure silently treats that as "no npm-shrinkwrap.json
# present" -- it packs a package.json with empty dependencies/devDependencies
# and do_compile's later 'npm install' installs nothing at all (no error).
SRC_URI = "git://github.com/gnuradio/gnuradio4-studio.git;protocol=https;branch=main \
           file://0001-package.json-trim-devDependencies-to-what-vite-build-needs.patch \
           npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json;dev=1;destsuffix=${BP} \
           "

PV = "0.1.0+git"
SRCREV = "006923a25f031e7c7cbae634ecaca4c5c75e3280"

inherit npm

LICENSE:${PN}-alloc-quick-lru = "MIT"
LICENSE:${PN}-babel-code-frame = "MIT"
LICENSE:${PN}-babel-compat-data = "MIT"
LICENSE:${PN}-babel-core = "MIT"
LICENSE:${PN}-babel-generator = "MIT"
LICENSE:${PN}-babel-helper-compilation-targets = "MIT"
LICENSE:${PN}-babel-helper-globals = "MIT"
LICENSE:${PN}-babel-helper-module-imports = "MIT"
LICENSE:${PN}-babel-helper-module-transforms = "MIT"
LICENSE:${PN}-babel-helper-plugin-utils = "MIT"
LICENSE:${PN}-babel-helper-string-parser = "MIT"
LICENSE:${PN}-babel-helper-validator-identifier = "MIT"
LICENSE:${PN}-babel-helper-validator-option = "MIT"
LICENSE:${PN}-babel-helpers = "MIT"
LICENSE:${PN}-babel-parser = "MIT"
LICENSE:${PN}-babel-plugin-transform-react-jsx-self = "MIT"
LICENSE:${PN}-babel-plugin-transform-react-jsx-source = "MIT"
LICENSE:${PN}-babel-template = "MIT"
LICENSE:${PN}-babel-traverse = "MIT"
LICENSE:${PN}-babel-types = "MIT"
LICENSE:${PN}-dnd-kit-accessibility = "MIT"
LICENSE:${PN}-dnd-kit-core = "MIT"
LICENSE:${PN}-dnd-kit-utilities = "MIT"
LICENSE:${PN}-esbuild-linux-x64 = "['MIT']"
LICENSE:${PN}-jridgewell-gen-mapping = "MIT"
LICENSE:${PN}-jridgewell-remapping = "MIT"
LICENSE:${PN}-jridgewell-resolve-uri = "MIT"
LICENSE:${PN}-jridgewell-sourcemap-codec = "MIT"
LICENSE:${PN}-jridgewell-trace-mapping = "MIT"
LICENSE:${PN}-napi-rs-lzma-linux-x64-gnu = "['MIT']"
LICENSE:${PN}-nodelib-fsscandir = "MIT"
LICENSE:${PN}-nodelib-fsstat = "MIT"
LICENSE:${PN}-nodelib-fswalk = "MIT"
LICENSE:${PN}-rolldown-pluginutils = "MIT"
LICENSE:${PN}-rollup-rollup-linux-x64-gnu = "['MIT']"
LICENSE:${PN}-tanstack-query-core = "MIT"
LICENSE:${PN}-tanstack-react-query = "MIT"
LICENSE:${PN}-types-babelcore = "MIT"
LICENSE:${PN}-types-babelgenerator = "MIT"
LICENSE:${PN}-types-babeltemplate = "MIT"
LICENSE:${PN}-types-babeltraverse = "MIT"
LICENSE:${PN}-types-d3-color = "MIT"
LICENSE:${PN}-types-d3-drag = "MIT"
LICENSE:${PN}-types-d3-interpolate = "MIT"
LICENSE:${PN}-types-d3-selection = "MIT"
LICENSE:${PN}-types-d3-transition = "MIT"
LICENSE:${PN}-types-d3-zoom = "MIT"
LICENSE:${PN}-types-estree = "MIT"
LICENSE:${PN}-vitejs-plugin-react = "MIT"
LICENSE:${PN}-xyflow-react = "MIT"
LICENSE:${PN}-xyflow-react-zustand = "MIT"
LICENSE:${PN}-xyflow-system = "MIT"
LICENSE:${PN}-any-promise = "MIT"
LICENSE:${PN}-anymatch = "ISC"
LICENSE:${PN}-arg = "MIT"
LICENSE:${PN}-autoprefixer = "MIT"
LICENSE:${PN}-baseline-browser-mapping = "Apache-2.0"
LICENSE:${PN}-binary-extensions = "MIT"
LICENSE:${PN}-braces = "MIT"
LICENSE:${PN}-browserslist = "MIT"
LICENSE:${PN}-camelcase-css = "MIT"
LICENSE:${PN}-caniuse-lite = "CC-BY-4.0"
LICENSE:${PN}-chokidar = "ISC AND MIT"
LICENSE:${PN}-chokidar-glob-parent = "ISC"
LICENSE:${PN}-classcat = "MIT"
LICENSE:${PN}-commander = "MIT"
LICENSE:${PN}-convert-source-map = "MIT"
LICENSE:${PN}-cookie = "MIT"
LICENSE:${PN}-cssesc = "MIT"
LICENSE:${PN}-d3-color = "ISC"
LICENSE:${PN}-d3-dispatch = "ISC"
LICENSE:${PN}-d3-drag = "ISC"
LICENSE:${PN}-d3-ease = "BSD-3-Clause"
LICENSE:${PN}-d3-interpolate = "ISC"
LICENSE:${PN}-d3-selection = "ISC"
LICENSE:${PN}-d3-timer = "ISC"
LICENSE:${PN}-d3-transition = "ISC"
LICENSE:${PN}-d3-zoom = "ISC"
LICENSE:${PN}-debug = "MIT"
LICENSE:${PN}-didyoumean = "Apache-2.0"
LICENSE:${PN}-dlv = "['MIT']"
LICENSE:${PN}-electron-to-chromium = "ISC"
LICENSE:${PN}-es-errors = "MIT"
LICENSE:${PN}-esbuild = "MIT"
LICENSE:${PN}-escalade = "MIT"
LICENSE:${PN}-fast-glob = "ISC AND MIT"
LICENSE:${PN}-fast-glob-glob-parent = "ISC"
LICENSE:${PN}-fastq = "ISC"
LICENSE:${PN}-fill-range = "MIT"
LICENSE:${PN}-fractionjs = "MIT"
LICENSE:${PN}-function-bind = "MIT"
LICENSE:${PN}-gensync = "MIT"
LICENSE:${PN}-glob-parent = "ISC"
LICENSE:${PN}-hasown = "MIT"
LICENSE:${PN}-is-binary-path = "MIT"
LICENSE:${PN}-is-core-module = "MIT"
LICENSE:${PN}-is-extglob = "MIT"
LICENSE:${PN}-is-glob = "MIT"
LICENSE:${PN}-is-number = "MIT"
LICENSE:${PN}-jiti = "MIT"
LICENSE:${PN}-js-tokens = "MIT"
LICENSE:${PN}-jsesc = "MIT"
LICENSE:${PN}-json5 = "MIT"
LICENSE:${PN}-lilconfig = "MIT"
LICENSE:${PN}-lines-and-columns = "MIT"
LICENSE:${PN}-loose-envify = "MIT"
LICENSE:${PN}-lru-cache = "ISC"
LICENSE:${PN}-merge2 = "MIT"
LICENSE:${PN}-micromatch = "MIT"
LICENSE:${PN}-ms = "MIT"
LICENSE:${PN}-mz = "MIT"
LICENSE:${PN}-nanoid = "MIT"
LICENSE:${PN}-node-releases = "MIT"
LICENSE:${PN}-normalize-path = "MIT"
LICENSE:${PN}-object-assign = "MIT"
LICENSE:${PN}-object-hash = "MIT"
LICENSE:${PN}-path-parse = "MIT"
LICENSE:${PN}-picocolors = "ISC"
LICENSE:${PN}-picomatch = "MIT"
LICENSE:${PN}-pirates = "MIT"
LICENSE:${PN}-postcss = "MIT"
LICENSE:${PN}-postcss-import = "MIT"
LICENSE:${PN}-postcss-js = "MIT"
LICENSE:${PN}-postcss-load-config = "MIT"
LICENSE:${PN}-postcss-nested = "MIT"
LICENSE:${PN}-postcss-selector-parser = "MIT"
LICENSE:${PN}-postcss-value-parser = "MIT"
LICENSE:${PN}-queue-microtask = "MIT"
LICENSE:${PN}-react = "MIT"
LICENSE:${PN}-react-dom = "MIT"
LICENSE:${PN}-react-refresh = "MIT"
LICENSE:${PN}-react-resizable-panels = "MIT"
LICENSE:${PN}-react-router = "MIT"
LICENSE:${PN}-react-router-dom = "MIT"
LICENSE:${PN}-read-cache = "MIT"
LICENSE:${PN}-readdirp = "MIT"
LICENSE:${PN}-resolve = "MIT"
LICENSE:${PN}-reusify = "MIT"
LICENSE:${PN}-rollup = "MIT"
LICENSE:${PN}-run-parallel = "MIT"
LICENSE:${PN}-scheduler = "MIT"
LICENSE:${PN}-semver = "ISC"
LICENSE:${PN}-set-cookie-parser = "MIT"
LICENSE:${PN}-source-map-js = "BSD-3-Clause"
LICENSE:${PN}-sucrase = "MIT"
LICENSE:${PN}-supports-preserve-symlinks-flag = "MIT"
LICENSE:${PN}-tailwindcss = "MIT"
LICENSE:${PN}-thenify = "MIT"
LICENSE:${PN}-thenify-all = "MIT"
LICENSE:${PN}-tinyglobby = "MIT"
LICENSE:${PN}-tinyglobby-fdir = "MIT"
LICENSE:${PN}-tinyglobby-picomatch = "MIT"
LICENSE:${PN}-to-regex-range = "MIT"
LICENSE:${PN}-ts-interface-checker = "Apache-2.0"
LICENSE:${PN}-tslib = "0BSD"
LICENSE:${PN}-update-browserslist-db = "MIT"
LICENSE:${PN}-uplot = "MIT"
LICENSE:${PN}-use-sync-external-store = "MIT"
LICENSE:${PN}-util-deprecate = "MIT"
LICENSE:${PN}-vite = "MIT"
LICENSE:${PN}-vite-fdir = "MIT"
LICENSE:${PN}-vite-picomatch = "MIT"
LICENSE:${PN}-yallist = "ISC"
LICENSE:${PN}-zod = "MIT"
LICENSE:${PN}-zustand = "MIT"
LICENSE:${PN} = "GPL-3.0-only AND MIT"

NPM_INSTALL_DEV = "1"

# gnuradio4-studio is a TypeScript/React/Vite frontend (not CMake), so unlike
# the other gnuradio4-* recipes it is built with npm.bbclass. Upstream's own
# devDependencies include electron, eslint*, @typescript-eslint/*, typescript
# and vitest, none of which this recipe's build needs -- see the accompanying
# patch (and its commit message) for why the trim runs 'vite build' directly
# instead of upstream's 'tsc -b && vite build' build:web script.
#
# npm.bbclass's own npm_do_compile installs via 'npm install <tarball>
# --global', and npm's global-install mode unconditionally skips the
# installed package's devDependencies -- no config (also=development,
# include=dev, ...) overrides this, it's how npm itself defines "global
# install". That makes npm_do_compile unusable here: the build needs vite,
# @vitejs/plugin-react, tailwind etc., all devDependencies. So do_compile is
# a full override doing a plain *local* install instead (which does include
# devDependencies by default), reusing NPM_PACKAGE -- the tarball source dir
# npm_do_configure (still inherited, unchanged) already populated with a
# package.json merging in resolved versions from npm-shrinkwrap.json, and the
# offline npm cache/registry it primed from the same shrinkwrap.
#
# This is a plain build-host (x86_64) install/build via nodejs-native -- the
# esbuild/rollup native binaries pulled in above are the *build host's*,
# which is correct since 'vite build' output is architecture-independent
# static web assets, not something that runs on target.
NPM_WEBBUILD_DIR = "${WORKDIR}/npm-webbuild"

python do_compile() {
    import shutil
    from bb.fetch.npm import NpmEnvironment

    webbuild_dir = d.getVar("NPM_WEBBUILD_DIR")
    bb.utils.remove(webbuild_dir, recurse=True)
    shutil.copytree(d.getVar("NPM_PACKAGE"), webbuild_dir)

    env = NpmEnvironment(d, configs=npm_global_configs(d))
    env.run(["npm", "install", "--legacy-peer-deps"], workdir=webbuild_dir)
    env.run(["npx", "vite", "build"], workdir=webbuild_dir)
}

# Ship only the static web bundle 'vite build' produces -- there is no
# "install node_modules and run under node on target" step for this package,
# unlike a typical npm.bbclass consumer, so override do_install entirely
# rather than use npm.bbclass's default (which stages a runnable node_modules
# tree under ${bindir}/${nonarch_libdir}).
do_install() {
    install -d ${D}${datadir}/gnuradio4-studio
    cp --no-preserve=ownership --recursive ${NPM_WEBBUILD_DIR}/dist/. ${D}${datadir}/gnuradio4-studio/
}

FILES:${PN} = "${datadir}/gnuradio4-studio"

# No node_modules ship to target, so npm.bbclass's automatic runtime
# dependency on nodejs doesn't apply -- this package is served as static
# files by a web server.
RDEPENDS:${PN}:remove = "nodejs"
