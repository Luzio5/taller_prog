#!/bin/sh
curl -v -u admin:admin -T tarea2/build/libs/tarea2.war 'http://localhost:8080/manager/text/deploy?path=/tarea2&update=true'
