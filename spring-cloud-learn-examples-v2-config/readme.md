##### spring-cloud-learn-examples-v2-config

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
## config 配置
spring.cloud.config.enabled=true
## 配置本地文件加载
spring.profiles.active=native
## 配置文件加载目录 [classpath:/,classpath:/config/,file:./,file:./config/]
spring.cloud.config.server.native.search-locations=file:///D://config

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

