package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志跟踪服务启动类
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 
 */
@SpringBootApplication
public class SleuthSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(SleuthSpringBootApplication.class, args);
	}


}
