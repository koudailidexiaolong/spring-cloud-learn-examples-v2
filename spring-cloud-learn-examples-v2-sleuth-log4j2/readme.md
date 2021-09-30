#### spring-cloud-learn-examples-v2-sleuth-log4j2

集成log4j2 配置 实现日志追踪

pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
<!-- 增加监控 actuator -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<!-- 日志跟踪服务 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```



```properties
spring.application.name=spring-cloud-learn-examples-v2-sleuth-log4j2
## 服务端口
server.port=18081


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env
## 开启关闭功能
management.endpoint.shutdown.enabled=true
## 是否启用热启动配置
spring.devtools.restart.enabled=false

## 启用日志跟踪服务
spring.sleuth.enabled=true
spring.sleuth.sampler.probability=10
### 配置zipkin web服务
spring.zipkin.enabled=true
spring.zipkin.service.name=${spring.application.name}
spring.zipkin.base-url=http://192.168.10.27:18080/


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



##### 关键配置 需要增加

​	 [%X{X-B3-ParentSpanId},%X{X-B3-TraceId},%X{X-B3-SpanId},%X{X-Span-Export}] 



依赖服务

##### 第一步启动：spring-cloud-learn-examples-v2-sleuth-zipkin

​			http://192.168.10.27:18080/zipkin/

##### 第二步启动：spring-cloud-learn-examples-v2-sleuth-log4j2

​			http://192.168.10.27:18081/user/1

