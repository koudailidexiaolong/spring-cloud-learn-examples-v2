package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 熔断服务集中治理
 * @author julong
 * @date 2021年9月23日 下午4:13:22
 * @desc 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class HystrixTurbineSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(HystrixTurbineSpringBootApplication.class, args);
	}

}
