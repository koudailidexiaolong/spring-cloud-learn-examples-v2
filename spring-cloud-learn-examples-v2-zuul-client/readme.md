###### spring-cloud-learn-examples-v2-zuul-client

​		api服务网关

引入依赖

```xml
<!-- 网关api -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```

application.properties

```properties
spring.application.name=spring-cloud-learn-examples-v2-zuul
## 服务端口
server.port=18080

#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env
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


### 配置 zuul
zuul.routes.api-a.path=/api-a/**
## 服务编号
zuul.routes.api-a.service-id=spring-cloud-learn-examples-v2-eureka-client


## 日志
logging.config=classpath:log4j2-spring.xml
#logging.level.root=INFO
#logging.level.org.springframework.web=DEBUG
#logging.level.org.hibernate=ERROR
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
info.app.applicaton.name=${spring.application.name}



```



访问方式：

​		http://192.168.10.27:18080/api-a/user

​		http://192.168.10.27:18080/spring-cloud-learn-examples-v2-eureka-client/user
