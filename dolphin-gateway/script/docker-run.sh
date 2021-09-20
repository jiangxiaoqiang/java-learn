#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x

APP_PATH="/data/jenkins/soa-room-service-docker"

cd ${APP_PATH}

# 构建镜像
docker build -t="soa-room-service" .

# 镜像推送到阿里云
docker push registry.cn-shanghai.aliyuncs.com/dabai_app/soa-room-service:1.0.0

# 本地运行镜像
# docker run -p 9081:9081 --name soa-room-service soa-room-service

