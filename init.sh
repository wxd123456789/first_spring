#!/usr/bin/env bash


mvn compile

# dev test prod
export profilesActive=dev

# different version pkg conflict
class_path="./target/classes/"

#SPRING_BASE_DIR="/root/.m2/repository"
SPRING_BASE_DIR="./lib"
springs=`find ${SPRING_BASE_DIR} -name *.jar`
for i in ${springs[*]};do class_path=$class_path:$i;done
#echo "${class_path}"


#java -cp $class_path com.wxd.my_mall.config.AppConfig
java -cp $class_path com.wxd.my_mall.Main