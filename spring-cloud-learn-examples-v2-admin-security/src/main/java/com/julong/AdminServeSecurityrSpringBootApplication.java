package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * admin 管理控制端 带有登录密码的请求管理端
 * @author julong
 * @date 2021年09月22日 21:08:20
 * @desc
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServeSecurityrSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(AdminServeSecurityrSpringBootApplication.class, args);
	}

}
