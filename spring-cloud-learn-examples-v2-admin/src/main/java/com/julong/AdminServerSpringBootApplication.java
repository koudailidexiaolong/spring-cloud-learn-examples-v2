package com.julong;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * admin 管理控制端
 * @author julong
 * @date 2021年09月22日 21:08:20
 * @desc
 */
@SpringBootApplication
@EnableAdminServer //启用admin 管理控制台
public class AdminServerSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(AdminServerSpringBootApplication.class, args);
	}

}
