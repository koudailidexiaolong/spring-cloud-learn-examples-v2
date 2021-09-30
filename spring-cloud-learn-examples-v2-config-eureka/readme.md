##### spring-cloud-learn-examples-v2-config-eureka

使用注册中心管理配置中心

```xml
<!-- 配置中心 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

application.properties

```prop
spring.application.name=spring-cloud-learn-examples-v2-config-eureka
## 服务端口
server.port=8888


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

## config 配置
spring.cloud.config.enabled=true
## 配置本地文件加载
spring.profiles.active=native
## 配置文件加载目录 [classpath:/,classpath:/config/,file:./,file:./config/]
spring.cloud.config.server.native.search-locations=file:///D://config

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


###### 默认配置信息
```text
   
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
```

本地配置信息

   ```properties
    配置信息
    ## 配置本地文件加载
    spring.profiles.active=native
    ## 配置文件加载目录 [classpath:/,classpath:/config/,file:./,file:./config/]
    spring.cloud.config.server.native.search-locations=file:///D://config/
   ```
 访问方式

 ```txt
    读取本地文件 
    	http://192.168.10.27:18080/spring-config/default
    	http://192.168.10.27:18080/spring-config.properties
 ```

 

```text
    http://192.168.10.27:18080/julong/spring-config.properties
    http://192.168.10.27:18080/spring-config.properties
    http://192.168.10.27:18080/spring-config/master
    http://192.168.10.27:18080/spring-config/default
```

##### 正规的文件名命名规则

    	http://192.168.10.27:18080/application-dev.properties
    	http://192.168.10.27:18080/application-prod.properties



依赖服务

第一步启动：spring-cloud-learn-examples-v2-eureka

​		访问地址：http://192.168.10.27:8761/

第二步启动：spring-cloud-learn-examples-v2-config-eureka

​		访问地址：http://192.168.10.27:8888/application-dev.properties
