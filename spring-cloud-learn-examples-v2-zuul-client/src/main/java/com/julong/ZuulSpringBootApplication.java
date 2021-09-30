package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * api服务网关服务启动类
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy    //启用zuul
public class ZuulSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(ZuulSpringBootApplication.class, args);
	}
	

}
