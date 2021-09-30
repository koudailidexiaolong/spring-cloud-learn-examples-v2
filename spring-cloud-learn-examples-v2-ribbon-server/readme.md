##### spring-cloud-learn-examples-v2-ribbon-server

​	eureka 注册服务端

配置信息

```xml
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```



```prop
spring.application.name=spring-cloud-learn-examples-v2-ribbon-server
## 服务端口
server.port=18087


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
# management.endpoints.web.exposure.exclude=env
## 开启关闭功能
management.endpoint.shutdown.enabled=true

## 是否启用热启动配置
spring.devtools.restart.enabled=false

## eureka配置
## 启用eureka客户端
eureka.client.enabled=true
## 启用服务自动注册eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
## 获取服务端注册的时间间隔
# eureka.client.registry-fetch-interval-seconds=
## 更新实例变化到注册中心的时间间隔
# eureka.client.initial-instance-info-replication-interval-seconds=
## 连接注册中心的超时时间
# eureka.client.eureka-server-connect-timeout-seconds=
## 读取注册中心的超时时间
#eureka.client.eureka-server-read-timeout-seconds=



## 启用心跳检测
eureka.client.healthcheck.enabled=true
## eureka 服务的配置地址
eureka.client.service-url.defalueZone=http://192.168.10.27:8761/eureka/
## 微服务的名称 默认为 spring.application.name 的值  如果此值也没有配置 默认为 unknown
eureka.instance.appname=${spring.application.name}
## 注册到eureka 服务的名称 如果多个服务 名字都叫一样则 在 注册中心 看到只有一个服务 通过 服务名+端口号来区分统一服务的不同注册服务
eureka.instance.instance-id=${spring.application.name}-${server.port}
## 是否启用真是IP地址进行注册 默认为false
eureka.instance.prefer-ip-address=true

## 日志
logging.level.root=INFO
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
## 服务信息
info.app.encoding=@project.build.sourceEncoding@
info.app.java.source=@java.version@
info.app.java.target=@java.version@
info.app.artifactId=@artifactId@
info.app.groupId=@groupId@
info.app.version=@version@
info.app.description=@description@
info.app.packaging=@packaging@
info.app.parent.groupId=@parent.groupId@
info.app.parent.artifactId=@parent.artifactId@
info.app.parent.version=@parent.version@
info.app.application.name=${spring.application.name}


```



依赖服务

###### 第一步启动：spring-cloud-learn-examples-v2-ribbon-eureka

​		访问地址：http://192.168.10.27:8761/

###### 第二步启动：spring-cloud-learn-examples-v2-ribbon-server 

此服务模拟多个服务 修改端口号

​		访问地址：http://192.168.10.27:18081/actuator/info