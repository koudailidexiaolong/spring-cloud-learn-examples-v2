package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 服务配置中心服务启动类
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(ConfigClientSpringBootApplication.class, args);
	}

}
