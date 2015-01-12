#!/bin/bash
# Skript für das Hochfahren von Umgebungen (z.B. Sonar, Artifactory, Tomcats, ...)
#source ./artifactory-docker/start.sh
source ./sonar-docker/start.sh
source ./tomcat/start.sh