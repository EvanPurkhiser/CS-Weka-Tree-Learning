#!/bin/bash

make
CLASSPATH=$CLASSPATH:weka.jar java TreeLearning
