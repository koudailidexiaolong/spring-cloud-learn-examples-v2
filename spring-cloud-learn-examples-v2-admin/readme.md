##### spring-cloud-learn-examples-v2-admin

​	微服务指标监控服务



pom.xml

```xml
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
    <version>2.0.6</version>
</dependency>
```



application.properties

```properties
spring.application.name=spring-cloud-learn-examples-v2-admin
## 服务端口
server.port=18080

#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env

## 启用admin 管理控制台服务配置
spring.application.admin.enabled=true
## admin 管理端ui 名称
spring.boot.admin.ui.title=Spring Boot Admin

## 是否启用热启动配置
spring.devtools.restart.enabled=true

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



```



访问方式：http://192.168.10.27:18080