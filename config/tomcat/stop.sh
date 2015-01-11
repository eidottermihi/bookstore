#!/bin/bash
echo "Stopping tomcat-test..."
docker stop tomcat-test
echo "Stopping tomcat-uat..."
docker stop tomcat-uat
echo "Stopping tomcat-prod..."
docker stop tomcat-prod
