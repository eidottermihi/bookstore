#!/bin/bash
# MySQL credentials: sonar:123qwe
echo "Run sonar-mysql..."
docker run -i -t -d -p 3306:3306 --name smysql tpires/sonar-mysql
echo "Run sonar-server..."
docker run -i -t -d --name sonar -p 9000:9000 --link smysql:db tpires/sonar-server