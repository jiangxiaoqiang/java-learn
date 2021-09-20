#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x

namespace=dabai-fat
param1="$1"
param2="$2"

while [ -n "${param1}" ]
do
  case "${param1}" in
    -n)
        namespace="${param2:-dabai-fat}"
        ;;
  esac
  break
done

./gradlew clean :zuul-service:build -x test
docker build -f ./Dockerfile -t="${namespace}/zuul-service:v1.0.0" .

docker tag ${namespace}/zuul-service:v1.0.0 registry.cn-hangzhou.aliyuncs.com/dabai_app_k8s/${namespace}/zuul:v1.0.0
docker push registry.cn-hangzhou.aliyuncs.com/dabai_app_k8s/${namespace}/zuul:v1.0.0

kubectl rollout restart deployment zuul-service -n ${namespace}
