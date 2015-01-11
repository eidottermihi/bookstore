#!/bin/bash
# Credentials = admin:s3cret
echo "Building Tomcat 7 with Java 8 image..."
docker build -t bookstore/tomcat .
echo "Run tomcat-test..."
docker run --name tomcat-test -d -p 11080:8080 bookstore/tomcat
echo "Run tomcat-uat..."
docker run --name tomcat-uat -d -p 12080:8080 bookstore/tomcat
echo "Run tomcat-prod..."
docker run --name tomcat-prod -d -p 13080:8080 bookstore/tomcat