##### spring-cloud-learn-examples-v2-config-git

配置中心

```xml
<!-- 配置中心 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

application.properties

```prop
spring.application.name=spring-cloud-learn-examples-v2-config
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


## config 配置 git版本
spring.cloud.config.enabled=true
## 设置git登录账户名
spring.cloud.config.server.git.username=koudailidexiaolong@163.com
## 设置git登录账户密码
spring.cloud.config.server.git.password=xiaolong0627
## 设置git访问地址
spring.cloud.config.server.git.uri=https://gitee.com/julong/spring-cloud-config.git


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

