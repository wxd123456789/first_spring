#!/usr/bin/env bash


mvn clean package
\cp -rf lib target/my_mall-1.0-SNAPSHOT/WEB-INF/
cd /home/zwx/my_mall/target/my_mall-1.0-SNAPSHOT
jar -cvfM0 my_mall-1.0-SNAPSHOT.war ./
mv my_mall-1.0-SNAPSHOT.war ROOT.war
scp -rp ROOT.war root@121.4.55.183:/mydata/tomcat/webapps/
