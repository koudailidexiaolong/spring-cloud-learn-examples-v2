package com.julong;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * admin 管理控制端
 * @author julong
 * @date 2021年09月22日 21:08:20
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer //启用admin 管理控制台
public class AdminEurekaServerSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(AdminEurekaServerSpringBootApplication.class, args);
	}

}
