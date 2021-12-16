#!/bin/bash -x
VERSION=$1
if [[ ! -z $VERSION ]]; then
    docker build --pull --no-cache --rm=true --build-arg ELASTICSEARCH_VERSION="$VERSION" -t openvidu/openvidu-elasticsearch:$VERSION .
else
    echo "Error: You need to specify a version as first argument"
fi
