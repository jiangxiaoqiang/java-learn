#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x

MAVEN_PATH="/data/env/maven/apache-maven-3.6.1/bin"

cd ${WORKSPACE}

# 编译service层
${MAVEN_PATH}/mvn clean package -Dmaven.test.skip=true -U

scp ${WORKSPACE}/target/zuul-service-1.0.0-SNAPSHOT.jar root@47.101.195.221:/data/jenkins/zuul-service

scp ${WORKSPACE}/script/upgrade.sh root@47.101.195.221:/data/jenkins/zuul-service


