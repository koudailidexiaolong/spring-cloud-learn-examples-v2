#### spring-cloud-learn-examples-v2-bus
消息服务总线

pom.xml

```xml
<!-- 消息总线 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>

```



application.properties

```properties
### 消息服务总线bus配置
spring.cloud.bus.enabled=true
## 消息地址
spring.rabbitmq.host=192.168.10.222
## 端口号
spring.rabbitmq.port=5672
## 账号姓名
spring.rabbitmq.username=admin
spring.rabbitmq.password=admin
spring.rabbitmq.virtual-host=/
```



测试类

```java
package com.julong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.julong.action.IndexAction;
import com.julong.service.message.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudLearnExamplesTests {

	@Autowired
	private IndexAction indexAction;
	
	@Autowired
	private Producer producer;
	
	/**
	 * 测试首页
	 * @author julong
	 * @date 2021年9月29日 下午3:35:00
	 * @desc
	 */
	@Test
	public void test(){
		String result = indexAction.home();
		System.out.println(result);
	}
	
	
	/**
	 * 测试消费者
	 * @author julong
	 * @date 2021年9月29日 下午3:34:48
	 * @desc
	 */
	@Test
	public void producerTest(){
		this.producer.send();
	}

	public static void main(String[] args) {

	}
}

```

