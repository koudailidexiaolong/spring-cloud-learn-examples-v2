package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务熔断仪表盘 图形界面
 * @author julong
 * @date 2021年9月23日 下午3:19:28
 * @desc 
 */
@SpringBootApplication
@EnableHystrixDashboard 
public class HystrixDashboardSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(HystrixDashboardSpringBootApplication.class, args);
	}

}
