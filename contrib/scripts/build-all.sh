export MACHINE=zedboard-zynq7

bitbake gnuradio-demo-image

wic create ../meta-sdr/contrib/wks/sdimage-8G.wks  -e gnuradio-demo-image -o images/$MACHINE
xz images/$MACHINE/build/sdimage*direct

export MACHINE=zc702-zynq7

bitbake gnuradio-demo-image

wic create ../meta-sdr/contrib/wks/sdimage-8G.wks  -e gnuradio-demo-image -o images/$MACHINE
xz images/$MACHINE/build/sdimage*direct

bitbake -c populate_sdk gnuradio-demo-image

