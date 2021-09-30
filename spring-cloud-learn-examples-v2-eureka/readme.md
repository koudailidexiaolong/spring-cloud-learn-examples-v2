##### spring-cloud-learn-examples-v2-eureka

服务治理服务端

配置信息：

```xml
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```



```properties
spring.application.name=spring-cloud-learn-examples-v2-eureka
## 服务端口
server.port=8761


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env

## 是否启用热启动配置
spring.devtools.restart.enabled=false

## 指定加载eureka 模板  如果配置了thymeleaf 模板 需要将此配置放开 如果不放 则后台启动会报错 但是不影响使用
spring.freemarker.enabled=true
spring.freemarker.template-loader-path=classpath:/templates/
spring.freemarker.prefer-file-system-access=false

## eureka配置
## 禁用服务自动注册eureka
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
## 设置服务端hostname为IP地址
eureka.instance.hostname=192.168.10.27
## 此服务的唯一标识符
eureka.instance.instance-id=${spring.application.name}
eureka.instance.appname=${spring.application.name}
## 暴露真实IP进行访问注册
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



访问地址：http://192.168.10.27:8761/

