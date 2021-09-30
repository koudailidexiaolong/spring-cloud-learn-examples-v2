##### spring-cloud-learn-examples-v2-feign-server

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
spring.application.name=spring-cloud-learn-examples-v2-eureka-client-3
## 服务端口
server.port=18083


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
## 禁用服务自动注册eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.enabled=true
## 启用心跳检测
eureka.client.healthcheck.enabled=true
## eureka 服务的配置地址
eureka.client.service-url.defalueZone=http://192.168.10.27:8761/eureka/
eureka.instance.appname=${spring.application.name}
## 注册到eureka 服务的名称
eureka.instance.instance-id=${spring.application.name}
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

###### 第一步启动：spring-cloud-learn-examples-v2-feign-eureka

​		访问地址：http://192.168.10.27:8761/

###### 第二步启动：spring-cloud-learn-examples-v2-feign-server

​		访问地址：http://192.168.10.27:18081/actuator/info