##### spring-cloud-learn-examples-v2-config-eureka-client

​		配置中心调用客户端



pom.xml

```xml
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!-- 配置中心 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```



application.properties

```properties
spring.application.name=spring-cloud-learn-examples-v2-config-eureka-client
## 服务端口
server.port=18086


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
## management.endpoints.web.exposure.exclude=env
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


### config 配置
spring.cloud.config.enabled=true
## 启用服务注册发现
spring.cloud.config.discovery.enabled=true
## 远程加载的文件名 默认为 application
spring.cloud.config.name=application
## 远程加载文件的定位信息  例如 xxx-dev ,prod,test 等
spring.cloud.config.profile=dev
## 注册服务地址
spring.cloud.config.discovery.service-id=spring-cloud-learn-examples-v2-config-eureka


spring.cloud.refresh.enabled=true

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



调用方式：

```java
@Value("${welcome.message}")
private String message;
```

刷新方式

```java
  public static void main(String[] args) {
        try {
            CloseableHttpClient client= HttpClients.createDefault();
            HttpPost post = new HttpPost("http://192.168.10.27:18086/actuator/refresh");
            CloseableHttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```







##### 服务依赖

###### 		第一步启动：spring-cloud-learn-examples-v2-eureka

​		访问地址：http://192.168.10.27:8761/

###### 		第一步启动：spring-cloud-learn-examples-v2-config-eureka

​		访问地址：http://192.168.10.27:8888/application-dev.properties

###### 		第二步启动：spring-cloud-learn-examples-v2-config-eureka-client

​		访问地址：http://192.168.10.27:18086/

