###### spring-cloud-learn-examples-v2-zuul

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
spring.devtools.restart.enabled=true


## 网关配置 默认拦截路径
zuul.routes.user.path=/api/**
## 网关配置转发的url 浏览器请求的url 中包含 /api 目录访问此路径
zuul.routes.user.url=http://localhost:18080/

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

​	http://192.168.10.27:18080/zuul/api/user

​	http://192.168.10.27:18080/api/user

​	http://192.168.10.27:18080/user

​	http://192.168.10.27:18080/zuul/user
