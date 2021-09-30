#### spring-cloud-learn-examples-v2-ribbon-client

​	客户端负载均衡

pom.xml

```xml
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!-- 客户端负载 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
		
```



application.properties

```prop
spring.application.name=spring-cloud-learn-examples-v2-ribbon-client
## 服务端口
server.port=18089


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env
## 开启关闭功能
management.endpoint.shutdown.enabled=true
## 是否启用热启动配置
spring.devtools.restart.enabled=true

### eureka 配置
## 启用eureka配置
eureka.client.enabled=true
## 注册到eureka 服务
eureka.client.fetch-registry=true
eureka.client.healthcheck.enabled=true
eureka.client.register-with-eureka=true
## 注册地址
eureka.client.service-url.defaultZone=http://192.168.10.27:8761/eureka
## 服务名称
eureka.instance.appname=${spring.application.name}
eureka.instance.instance-id=${spring.application.name}
## 真实IP地址
eureka.instance.prefer-ip-address=true
## 启用eureka 中使用 ribbon配置
ribbon.eureka.enabled=true

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



客户端负载配置

```java
package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 客户端负载均衡
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(RibbonSpringBootApplication.class, args);
	}

	/**
	 * 注册rest模板接口
	 * @return
	 * @author julong
	 * @date 2021年9月27日 下午1:26:44
	 * @desc
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}

```





###### 依赖服务：

​		第一步启动：spring-cloud-learn-examples-v2-ribbon-eureka

​				访问地址：http://192.168.10.27:8761/

​		第二步启动：spring-cloud-learn-examples-v2-ribbon-server 

​				此服务模拟多个服务 修改端口号

​				访问地址：http://192.168.10.27:18081/actuator/info

​		第三步启动：spring-cloud-learn-examples-v2-ribbon-client

​				访问地址：http://192.168.10.27:18089/template/user/1

