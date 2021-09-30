##### spring-cloud-learn-examples-v2-feign-client

​	声明式服务调用



引入配置

pom.xml

```xml
<!-- 引入发现服务 eureka -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!-- 引入feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```



application.properties

```properties
spring.application.name=spring-cloud-learn-examples-v2-feign-client
## 服务端口
server.port=18088


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env
## 开启关闭功能
management.endpoint.shutdown.enabled=true
## 是否启用热启动配置
spring.devtools.restart.enabled=true


## eureka配置
## 启用eureka客户端
eureka.client.enabled=true
## 启用服务自动注册eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
## 获取服务端注册的时间间隔
# eureka.client.registry-fetch-interval-seconds=
## 更新实例变化到注册中心的时间间隔
# eureka.client.initial-instance-info-replication-interval-seconds=
## 连接注册中心的超时时间
# eureka.client.eureka-server-connect-timeout-seconds=
## 读取注册中心的超时时间
#eureka.client.eureka-server-read-timeout-seconds=
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

## 配置feign
## 对请求响应进行gzip压缩 默认配置为 false
feign.compression.request.enabled=true
feign.compression.response.enabled=true


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



关于类中配置：

```java
package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 声明式服务调用启动类
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients 
public class OpenFeignSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(OpenFeignSpringBootApplication.class, args);
	}

}

```



```java
package com.julong.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julong.service.dto.UserDTO;

/**
 * 用户模块
 * @author julong
 * @date 2021年9月23日 下午5:52:56
 * @desc  @FeignClient 通过此参数来绑定服务调用的名称
 */
@FeignClient(name="spring-cloud-learn-examples-v2-eureka-client") 
public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:53:57
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public abstract void saveUser(@RequestBody UserDTO user);
	
	/**
	 * 更新用户
	 * @param id
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:54:09
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
	public abstract void updateUser(@PathVariable("id") String id, @RequestBody UserDTO user);
	/**
	 * 删除用户
	 * @param id
	 * @author julong
	 * @date 2021年9月23日 下午5:54:16
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public abstract void deleteUser(@PathVariable("id") String id);
	/**
	 * 查询用户集合
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午5:54:22
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public abstract Collection<UserDTO> getUserList();
	
	/**
	 * 获取单个用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:21:59
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public abstract UserDTO getUser(@PathVariable("id") String id);

}

```





依赖服务

第一步启动：spring-cloud-learn-examples-v2-feign-eureka

​		访问路径：http://192.168.10.27:8761/

第二步启动：spring-cloud-learn-examples-v2-feign-server

​		访问服务：http://192.168.10.27:18082/actuator/info http://192.168.10.27:18087/actuator/info

第三步启动：spring-cloud-learn-examples-v2-feign-client

​		访问服务：http://192.168.10.27:18088/user/1
