#!/bin/bash

imageName=alticcibe:1.0

docker build -t $imageName .
docker run --name alticci-back-end -d -p 8080:8080 $imageName