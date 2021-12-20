#!/bin/bash

mkdir -p ptest-output/$MACHINE
cd ptest-output/$MACHINE

runqemu qemuparams="-m 4096" gnuradio-ptest-image &

if [ -d ../.git ]; then
	git checkout $BRANCH
	git pull origin $BRANCH
fi

until ssh root@192.168.7.2 'ls'
	do	
		sleep 1
	done

ssh root@192.168.7.2 'ptest-runner -t 1000; shutdown -hf now' | tee ptest.log

sed -i s/[0-9]*\.[0-9][0-9].sec// ptest.log
sed -i '/^BEGIN: \/usr\/lib\/fftw\/ptest/,/^fftw  test result:/{//!d}' ptest.log


if [ -d ../.git ]; then
	git add ptest.log
	(cd ../..; git log HEAD -1) | git commit -F -
	git push origin $BRANCH
fi

