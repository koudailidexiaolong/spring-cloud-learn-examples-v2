package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * eureka服务发现 客户端启动类
 * @author julong
 * @date 2021年9月23日 上午10:28:57
 * @desc 
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(EurekaClientSpringBootApplication.class, args);
	}

}
