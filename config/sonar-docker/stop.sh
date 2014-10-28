#!/bin/bash
echo "Stopping sonar-mysql..."
docker stop smysql
echo "Stopping sonar-server..."
docker stop sonar