
## mallverset 是一个基于SpringBoot的商城项目
```
git remote add origin https://github.com/whboy713/mallverset.git
-- 本地master提交远程main 
git push origin master:main
```


## 环境安装准备
### 使用Docker部署mysql
```bash
# 拉取镜像
docker pull registry.cn-hangzhou.aliyuncs.com/whboy_live/mysql:8.0.28
# 创建容器
docker run -id \
--name mysql-mallverset \
-p 3317:3306 \
-v mysql_data:/var/lib/mysql \
-v mysql_conf:/etc/mysql \
--restart=always --privileged=true -e MYSQL_ROOT_PASSWORD=1234 \
registry.cn-hangzhou.aliyuncs.com/whboy_live/mysql:8.0.28
```
注意：端口映射[3317:3306]，挂载卷[`mysql_data:/var/lib/mysql`][`mysql_conf:/etc/mysql`]，环境变量[`MYSQL_ROOT_PASSWORD=1234`]

### 使用Docker部署Redis
```bash
# 拉取redis镜像
docker pull registry.cn-hangzhou.aliyuncs.com/whboy_live/redis:7.0.10

# 创建容器redis-mallverset
docker run -id \
-p 6380:6379 \
--restart=always \
-v redis-config:/etc/redis/config \
-v redis-data:/data \
--name redis-mallverset \
registry.cn-hangzhou.aliyuncs.com/whboy_live/redis:7.0.10 \
redis-server /etc/redis/config/redis.conf
```
- `docker run`: 启动一个新的容器。
- `-id`: -i 表示以交互模式运行容器，-d 表示在后台运行容器。
- `-p 6380:6379`: 将主机的 6380 端口映射到容器的 6379 端口。
- `--restart=always`: 设置容器的重启策略为总是重启。
- `-v redis-config:/etc/redis/config`: 将主机的 redis-config 目录挂载到容器的 /etc/redis/config 目录。
- `-v redis-data:/data`: 将主机的 redis-data 目录挂载到容器的 /data 目录。
- `--name redis-mallverset`: 为容器指定一个名称 redis-mallverset。
- `registry.cn-hangzhou.aliyuncs.com/whboy_live/redis:7.0.10`: 指定使用的镜像及其版本。
- `redis-server /etc/redis/config/redis.conf`: 在容器中启动 Redis 服务器，并指定配置文件路径。
```bash
# 查看数据卷到位置
[root@localhost ~]# docker inspect redis-mallverset
[root@localhost ~]# cd /var/lib/docker/volumes/redis-config/_data/
[root@localhost ~]# vim redis.conf
# 开启持久化
appendonly yes
port 6379
# 密码
requirepass 1234
# 开启远程连接
bind 0.0.0.0
protected-mode no
```
```bash
# 重新启动容器远程连接测试
docker restart redis-mallverset
```