#!/bin/bash
echo "Starting tomcat-test..."
docker start tomcat-test
echo "Starting tomcat-uat..."
docker start tomcat-uat
echo "Starting tomcat-prod..."
docker start tomcat-prod
