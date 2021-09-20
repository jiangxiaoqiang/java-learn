#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x

tags="$1"
deployment="zuul-service"
namescspaces="dabai-pro"
harbor="harbor.sxshy.net/miaoyou/${namescspaces}/${deployment}"
harbor2="47.106.208.55:6543/miaoyou/${namescspaces}/${deployment}"



# 构建可执行jar包
./gradlew clean :zuul-service:build -x test
docker build -f ./Dockerfile -t="${namescspaces}/${deployment}:${tags}" .

docker tag ${namescspaces}/${deployment}:${tags} ${harbor2}:${tags}


a=`docker push ${harbor2}:${tags}`
a=`echo $a`

b=" sha256:"
c=" size:"
start_index=$(awk -v a="$a" -v b="$b" 'BEGIN{print index(a,b)}')
end_index=$(awk -v a="$a" -v b="$c" 'BEGIN{print index(a,b)}')


digest=${a:start_index:end_index-start_index}

/Users/dabaidabai/.jenkins/workspace/build_shell/update_harbor_image.sh $deployment $harbor $digest $namescspaces

