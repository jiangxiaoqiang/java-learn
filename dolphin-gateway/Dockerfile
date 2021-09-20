FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.11_9_openj9-0.26.0-alpine

MAINTAINER jiangxiaoqiang (jiangtingqiang@gmail.com)

ENV LANG=en_US.UTF-8 \
    LC_ALL=en_US.UTF-8 \
    TZ=Asia/Shanghai

# 设置时区
# 镜像中经常会使用curl命令，在构建阶段加入，避免反复下载
# 另外bind-tools提供dig命令，busybox-extras包含网络诊断工具telnet
# RUN命令写一行，减少镜像体积
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo $TZ > /etc/timezone

ADD build/libs/dolphin-gateway-1.0.0-SNAPSHOT.jar /root/dolphin-gateway-1.0.0-SNAPSHOT.jar

EXPOSE 11014

ENTRYPOINT exec java -Dfile.encoding=UTF-8 -Xmx256M -Xms128M \
                -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=5019 \
                -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/dump \
                -jar /root/dolphin-gateway-1.0.0-SNAPSHOT.jar
