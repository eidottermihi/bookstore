#!/bin/bash
# Credentials = admin:password
echo "Run artifactory..."
docker run -d -name artifactory -p 10000:8080 mattgruter/artifactory