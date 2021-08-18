#!/usr/bin/env bash
args=$@
sbt -v "test:runMain Adder2.Launcher $args" 
