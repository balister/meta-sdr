#!/bin/bash

mkdir -p ptest-output/$MACHINE
cd ptest-output/$MACHINE

runqemu qemuparams="-m 2048" gnuradio-ptest-image &

sleep 45

ssh root@192.168.7.2 'ptest-runner; shutdown -hf now' | tee ptest.log

sed -i s/[0-9]*\.[0-9][0-9].sec// ptest.log

if [ -d ../.git ]; then
	git checkout $BRANCH
	git add ptest.log
	(cd ../..; git log HEAD -1) | git commit -F -
	git push origin $BRANCH
fi

