package com.julong.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class IndexAction {

	@RequestMapping("/")
	public String home() {
		return "Hello Spring Boot 2.0.0 !";
	}
	/**
	 * 服务熔断测试
	 * @return
	 * @throws InterruptedException
	 * @author julong
	 * @date 2021年9月23日 下午2:35:57
	 * @desc 其中  @HystrixProperty 属性 存放于 {@link com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager} 
	 */
	@RequestMapping("/index")
	@HystrixCommand(fallbackMethod = "hystrixMethod",
	    commandProperties = {
	    		      @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1000")
		}
	)
	public String index() throws InterruptedException {
		Thread.sleep(100000);
		return "Hello Spring Boot 2.0.0 !";
	}
	
	
	/**
	 * 请求超时返回的信息
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午2:49:38
	 * @desc
	 */
	@SuppressWarnings("unused")
	private String hystrixMethod() {
		return "Hello Spring Boot 2.0.0 hystrix!";
	}
	
	
}
