#!/bin/bash

mkdir -p ptest-output/$MACHINE
cd ptest-output/$MACHINE

runqemu publicvnc qemuparams="-m 2048" gnuradio-ptest-image &

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
sed -i '/^BEGIN: \/usr\/lib\/fftw\/ptest/,/^fftw  test result:/{//!d}' ptest.log


if [ -d ../.git ]; then
	git add ptest.log
	(cd ../..; git log HEAD -1) | git commit -F -
	git push origin $BRANCH
fi

