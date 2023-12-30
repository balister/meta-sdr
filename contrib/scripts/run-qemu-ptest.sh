#!/bin/bash

mkdir -p ptest-output/$MACHINE
cd ptest-output/$MACHINE

QEMUPARAMS="-m 4096"

if [ "$MACHINE" = "qemuarm"  ]; then
	QEMUPARAMS="-m 2048"
fi;
echo "QEMUPARAMS = " $QEMUPARAMS
echo "MACHINE = " $MACHINE

runqemu publicvnc qemuparams="$QEMUPARAMS" gnuradio-ptest-image &

if [ -d ../.git ]; then
	git checkout $BRANCH
	git clean -xdf
	git fetch origin
	git reset --hard origin/$BRANCH
fi

ssh -o ConnectionAttempts=50 root@192.168.7.2 'ptest-runner -t 1000; shutdown -hf now' | tee ptest.log

if [ ${PIPESTATUS[0]} != "0" ]; then
	exit 0
fi

sed -i 's/\s*[0-9]*\.[0-9][0-9].sec//' ptest.log
sed -E -i '/^BEGIN: \/usr\/lib\/fftw\/ptest/,/^PASS|^FAIL/{//!d}' ptest.log


if [ -d ../.git ]; then
	git add ptest.log
	(cd ../..; git log HEAD -1) | git commit -F -
	git push origin $BRANCH
fi

