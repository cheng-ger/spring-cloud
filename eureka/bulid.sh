#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t hub.c.163.com.chenggers/eureka .

docker push -t hub.c.163.com.chenggers/eureka