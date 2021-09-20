#!/usr/bin/env bash

# 当使用未初始化的变量时，程序自动退出
# 也可以使用命令 set -o nounset
set -u

# 当任何一行命令执行失败时，自动退出脚本
# 也可以使用命令 set -o errexit
set -e

set -x


JAVA_HOME="/opt/dabai/tools/jdk1.8.0_211"
APP_HOME="/data/jenkins/zuul-service"
APP_NAME="zuul-service-1.0.0-SNAPSHOT.jar"

PID=`ps -ef|grep -w ${APP_NAME}|grep -v grep|cut -c 9-15`
if [[ ${PID} -gt 1 ]]; then
        kill -9 ${PID}
        sleep 5
else
        echo "Process not found"
fi

count=`ps -ef | grep ${APP_NAME} | grep -v "grep" | wc -l`
if [[ ${count} -lt 1 ]]; then
  cd ${APP_HOME}
  nohup ${JAVA_HOME}/bin/java -Xmx256M -Xms128M -jar \
  -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=5014 \
  ${APP_HOME}/${APP_NAME} >> /dev/null &
  sleep 5
else
  echo "process aready exists!"
  exit 1
fi


#nohup ${JAVA_HOME}/bin/java -jar ${APP_HOME}/soa-report-service-1.0.0-SNAPSHOT.jar >> /dev/null &
