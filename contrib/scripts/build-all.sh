export MACHINE=zedboard-zynq7

if ! bitbake gnuradio-demo-image; then
	echo Failed building image for $MACHINE
	exit 1
fi

rm -rf images/$MACHINE/build
if ! wic create ../meta-sdr/contrib/wks/sdimage-8G.wks  -e gnuradio-demo-image -o images/$MACHINE; then
	echo Failed building sd card for $MACHINE
	exit 1
fi

xz images/$MACHINE/build/sdimage*direct

MACHINE=zc702-zynq7

if ! bitbake gnuradio-demo-image; then
	echo Failed building image for $MACHINE
	exit 1
fi

rm -rf images/$MACHINE/build
if ! wic create ../meta-sdr/contrib/wks/sdimage-8G.wks  -e gnuradio-demo-image -o images/$MACHINE; then
	echo Failed building sd card for $MACHINE
	exit 1
fi

xz images/$MACHINE/build/sdimage*direct

if ! bitbake -c populate_sdk gnuradio-demo-image; then
	echo Failed building sdk
	exit 1
fi

