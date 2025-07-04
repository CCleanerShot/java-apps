#!/bin/bash

# script file to run the maven build

cd ..
mvn clean
mvn package
PATH_TO_FOLDER="./apps/credit-card-validator/target"
JAR_FILE=$(ls $PATH_TO_FOLDER | grep jar)
java -jar "$PATH_TO_FOLDER/$JAR_FILE"