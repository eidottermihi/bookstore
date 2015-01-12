#!/bin/bash
echo "Starting sonar-mysql..."
docker start smysql
echo "Starting sonar-server..."
docker start sonar