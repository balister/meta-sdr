#!/bin/bash

mkdir -p ptest-output/$MACHINE
cd ptest-output/$MACHINE

runqemu gnuradio-ptest-image &

sleep 45

ssh root@192.168.7.2 'ptest-runner; shutdown -hf now' > ptest.log


