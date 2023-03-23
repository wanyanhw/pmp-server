# 基础镜像文件
FROM centos:latest
# 本次镜像创建人
MAINTAINER wanyanhw
# 进入工作目录
WORKDIR /usr
# 创建一个我们需要的目录
RUN mkdir /usr/java
# 将我们准备好的软件包放到刚创建的文件夹中
ADD jdk-8u351-linux-x64.tar.gz /usr/java/
# 设置环境变量
ENV JAVA_HOME /usr/java/jdk1.8.0_351
ENV JRE_HOME $JAVA_HOME/jre
ENV CLASSPATH $JAVA_HOME/bin/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib:$CLASSPATH
ENV PATH $JAVA_HOME/bin:$PATH