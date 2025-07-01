# helper script file to build and package with maven, build with gradle, and test with both

GREEN="\033[0;32m"
RED="\033[0;31m"
WHITE="\033[0m"
YELLOW="\033[1;33m"

RAN=0

if [ $1 = "maven" ]; then
    RAN=1
    ./credit-card-validator-maven-run.sh
fi

if [ $1 = "gradle" ]; then
    RAN=1
    ./credit-card-validator-gradle-run.sh
fi

if [ $RAN -eq 0 ]; then
    echo -e $RED"WARNING: Invalid optional parameter for running the monorepo! Valid options: maven, gradle"$WHITE
    exit 0
fi

if [ $RAN -eq 1 ]; then
    exit 0
fi


# run tests-only instead
echo -e $RED"------TESTING WITH MAVEN------"$WHITE
./credit-card-validator-maven-test.sh
echo -e $YELLOW"------TESTING WITH GRADLE------"$WHITE
./credit-card-validator-gradle-test.sh
echo -e $GREEN"------DONE!------"$WHITE

if [ "$#" -eq 0 ]; then
    exit 0
fi


# TODO: check exit code of scripts to see if one uniquely failed