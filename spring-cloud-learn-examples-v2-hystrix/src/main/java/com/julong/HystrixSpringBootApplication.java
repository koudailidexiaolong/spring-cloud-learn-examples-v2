package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * hystrix 服务熔断 服务启动类
 * @author julong
 * @date 2021年9月23日 下午2:08:55
 * @desc 
 */
@SpringBootApplication
@EnableCircuitBreaker // @EnableHystrix  两个注解都可以实现 熔断服务注册
public class HystrixSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(HystrixSpringBootApplication.class, args);
	}

}
