package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

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

	/**
	 * 声明式服务日志
	 * @return
	 * @author julong
	 * @date 2021年9月28日 下午3:00:48
	 * @desc
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
