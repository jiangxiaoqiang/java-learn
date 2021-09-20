#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x

MAVEN_PATH="/data/env/maven/apache-maven-3.6.1/bin"

REMOTE_SERVER_PATH="/data/jenkins/soa-room-service-docker"

APP_NAME="soa-room-service-1.0.0-SNAPSHOT.jar"

cd ${WORKSPACE}/soa-room-api

${MAVEN_PATH}/mvn clean package deploy -Dmaven.test.skip=true -U

cd ${WORKSPACE}/soa-room-service

# 编译service层
${MAVEN_PATH}/mvn clean package -Dmaven.test.skip=true -U

scp ${WORKSPACE}/soa-room-service/target/${APP_NAME} root@47.101.195.221:${REMOTE_SERVER_PATH}

scp ${WORKSPACE}/script/upgrade.sh root@47.101.195.221:${REMOTE_SERVER_PATH}

scp ${WORKSPACE}/soa-room-service/Dockerfile root@47.101.195.221:${REMOTE_SERVER_PATH}

