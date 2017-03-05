#!/bin/bash

#check jdk version
JAVA_VERSION=`echo "$(java -version 2>&1)" | grep "java version" | awk '{ print substr($3, 2, length($3)-7); }'`
COMMAND=$0
COMMAND=${COMMAND:2}

if [[ "$JAVA_VERSION" < "1.7" ]]; then
        echo [$COMMAND] Error: Sorry your $JAVA_VERSION Java Version is too old. Please Install a version above 1.7.
fi


#launch application
java {librairieList} {appClass} $*

