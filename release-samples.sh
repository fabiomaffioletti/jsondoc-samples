#!/bin/bash

if [ -z "$1" ] 
    then 
        echo "Specify release version as first argument"
	exit 0
fi

RELEASEVERSION=${1}

echo "Updating samples..."
sed -i '' "s/<jsondoc.version>.*<\/jsondoc.version>/<jsondoc.version>$RELEASEVERSION<\/jsondoc.version>/g" ../jsondoc-samples/pom.xml
mvn clean package -Pappfog

echo "Pushing changes to samples..."
git add .
git commit -m "updated jsondoc version"
git push origin master

echo "Update sample on Appfog..."
cd jsondoc-cloud
af update jsondoc


