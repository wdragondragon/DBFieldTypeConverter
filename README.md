## DBFieldTypeConverter Java Project
不同类型数据源的字段类型的相互转换工具，

### docker 快速启动数据库


#### 1.mysql
```shell
docker run --restart=always -d -v /var/data/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=951753 --network mysql-network --name mysql mysql:8.0.21
127.0.0.1:3306
root 951753
```

#### 2.oracle
```shell
docker run -it -d -p 1521:1521 -v /var/data/oracle:/data/oracle --name oracle11 registry.cn-hangzhou.aliyuncs.com/helowin/oracle_11g

sqlplus /nolog

发现没有该命令，所以切换root用户。

su root 

输入密码：helowin

编辑profile文件配置ORACLE环境变量

打开：vi /etc/profile ，在文件最后写上下面内容：
export ORACLE_HOME=/home/oracle/app/oracle/product/11.2.0/dbhome_2
export ORACLE_SID=helowin
export PATH=$ORACLE_HOME/bin:$PATH
source /etc/profile
创建软连接 ln -s $ORACLE_HOME/bin/sqlplus /usr/bin
su - oracle

登录sqlplus并修改sys、system用户密码

sqlplus /nolog   --登录
conn /as sysdba

alter user system identified by system;
alter user sys identified by system;
create user test identified by test;
grant connect,resource,dba to test;
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;
alter system set processes=1000 scope=spfile;
conn /as sysdba
shutdown immediate; --关闭数据库
startup; --启动数据库
exit


127.0.0.1:1521
服务名 helowin
test:test

```


#### 3.sqlserver
```shell

sudo docker pull mcr.microsoft.com/mssql/server:2019-latest
#启动
docker run -e 'ACCEPT_EULA=Y' -e 'MSSQL_SA_PASSWORD=Zhjl.sqlserver' \
--name sqlserver -h sqlserver \
-p 1433:1433 \
-v sqlvolume:/var/opt/mssql \
-d mcr.microsoft.com/mssql/server:2019-latest

#查看数据卷
docker volume ls

#密码修改
sudo docker exec -it sql1 /opt/mssql-tools/bin/sqlcmd \
   -S localhost -U SA -P "旧密码" \
   -Q 'ALTER LOGIN SA WITH PASSWORD="新密码"'
   
   
127.0.0.1:1433
SA Zhjl.sqlserver

```


#### 4.postgresql
```shell
docker pull postgres:10.16

docker run -d \
--name postgres \
-p 15432:5432 \
-e POSTGRES_USER=jdragon \
-e POSTGRES_PASSWORD=Zhjl.postgres \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v /var/data/pg:/var/lib/postgresql/data \
postgres:10.16

127.0.0.1:15432
jdragon Zhjl.postgres

```


#### 5.dm
```shell
wget -O dm8_docker.tar -c http://download.dameng.com/eco/dm8/dm8_docker.tar
docker import dm8_docker.tar dm8:v01


docker run -d  -p 31880:8080 -p 30236:5236 --name dm \
-e LD_LIBRARY_PATH=/opt/dmdbms/bin  \
-e INSTANCE_NAME=testdb \
-v /var/data/dm8/data:/opt/dmdbms/data \
-v /var/data/dm8/dm8.key:/opt/dmdbms/bin/dm.key \
dm8:v01 /bin/bash /startDm.sh

127.0.0.1:31880
testdb
SYSDBA SYSDBA
```

#### 6.gauss
```shell
# https://hub.docker.com/r/enmotech/opengauss
docker run --name opengauss --privileged=true -d -e GS_PASSWORD=Gauss@123 -v /var/data/opengauss:/var/lib/opengauss  -u root -p 11432:5432 enmotech/opengauss:latest

127.0.0.1:11432
gaussdb Gauss@123
postgres
```

#### 7.db2
```shell
docker pull ibmoms/db2

docker run -itd --name mydb2 --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=db2@123 -e DBNAME=testdb -v /var/data/db2:/database ibmcom/db2

db2inst1/db2@123

su - db2inst1 // 切换用户
db2start //启动DB2
db2sampl // 创建默认的数据库SAMPLE


[root@localhost /]# su - db2inst1
Last login: Wed May 20 21:57:28 UTC 2015
[db2inst1@localhost ~]$ db2start
SQL1063N  DB2START processing was successful.
[db2inst1@localhost ~]$ db2sampl 

  Creating database "SAMPLE"...
  Connecting to database "SAMPLE"...
  Creating tables and data in schema "DB2INST1"...
  Creating tables with XML columns and XML data in schema "DB2INST1"...

  'db2sampl' processing complete.

# 常用命令
db2 create db [dbname]   #创建数据库
db2 list db directory  # 列出所有数据库
db2 list active databases  # 列出所有激活的数据库
db2 get db cfg # 列出所有数据库配置


127.0.0.1:50000
db2inst1:db2@123
testdb
```

#### 8.clickhouse
```shell
# 拉取 server 镜像
docker pull clickhouse/clickhouse-server:21.12.3

docker run -d --name temp-clickhouse-server -p 8123:8123 --ulimit nofile=262144:262144 clickhouse/clickhouse-server:21.12.3

docker cp temp-clickhouse-server:/etc/clickhouse-server ./config
docker cp temp-clickhouse-server:/var/log/clickhouse-server ./log
docker stop temp-clickhouse-server

docker run -d \
 --name=clickhouse-server \
 -p 18123:8123 -p 19000:9000 -p 19009:9009 \
 --ulimit nofile=262144:262144 \
 --platform linux/amd64 \
 -v /var/data/clickhouse/data:/var/lib/clickhouse:rw \
 -v /var/data/clickhouse/config:/etc/clickhouse-server:rw \
 -v /var/data/clickhouse/log:/var/log/clickhouse-server:rw \
 -e CLICKHOUSE_DB=my_database \
 -e CLICKHOUSE_USER=test \
 -e CLICKHOUSE_PASSWORD=test \
 clickhouse/clickhouse-server:21.12.3
 
 
127.0.0.1:18123
test:test
my_database
```

#### 9.KingBaseEsV8R3
```shell
#https://registry.hub.docker.com/r/godmeowicesun/kingbase

#授权文件地址，下载授权文件，重命名为license.dat
#https://www.kingbase.com.cn/sqwjxz/index.htm
docker pull godmeowicesun/kingbase
mkdir -p /var/data/kingbase/opt
chmod 777 /var/data/kingbase/opt
mkdir -p /var/data/kingbase/opt/license
cp license.dat /var/data/kingbase/opt/license/
docker run -d -it --privileged=true -p 14321:54321 -v /var/data/kingbase/opt:/opt --name kingbase-rv1 godmeowicesun/kingbase:latest

# 注意，如果使用开发版license，需要修改配置文件中
max_connections=10
superuser_reserved_connections=0

#端口: 14321
#用户名: SYSTEM
#密码: 123456
#默认数据库: TEST
```

#### 10.GBase8A
```shell
#https://hub.docker.com/r/shihd/gbase8a
docker pull shihd/gbase8a:1.0
docker run -itd -p 5258:5258 --name gbase8a shihd/gbase8a:1.0

# 启动时发现无法启动。内存不足
#[ERROR] /home/gbase/GBase/server/bin/gbased: Gbase general error: Memory manager is unable to allocate specified amount of memory

# 将gbase挂载出来，修改config
docker cp gbase8a:/home/gbase /var/data/gbase
vim /var/data/gbase/GBase/config/gbase_8a_gbase8a.cnf

# 修改以下配置
gbase_heap_data=1G
gbase_heap_temp=256M
gbase_heap_large=256M

#挂载目录，重启gbase
docker run -itd -p 5258:5258 -v /var/data/gbase:/home/gbase --name gbase8a shihd/gbase8a:1.0

DB: gbase
User: root
Password: root
Port: 5258
jdbcUrl: jdbc:gbase://127.0.0.1:5258/gbase
```