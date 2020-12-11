#!/usr/bin/env bash


# servser pkg
cd ../
mvn clean package
\cp -rf lib target/my_mall-1.0-SNAPSHOT/WEB-INF/
cd /home/zwx/my_mall/target/my_mall-1.0-SNAPSHOT
jar -cvfM0 my_mall-1.0-SNAPSHOT.war ./
mv my_mall-1.0-SNAPSHOT.war ROOT.war
scp -rp ROOT.war root@121.4.55.183:/mydata/tomcat/webapps/
docker restart tomcat

# iui pkg
cd /home/zwx/mall-admin-web-master-client
npm run build
tar  -czvf dist.tar.gz dist
scp -rp ./dist.tar.gz root@121.4.55.183:/mydata/nginx/
# in prod env
cd /mydata/nginx
tar -zxvf dist.tar.gz
mv dist/* html
docker restart nginx