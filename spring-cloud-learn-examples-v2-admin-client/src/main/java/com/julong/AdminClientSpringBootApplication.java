package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * admin 客户端服务
 * @author julong
 * @date 2021年09月22日 21:08:20
 * @desc
 */
@SpringBootApplication
public class AdminClientSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(AdminClientSpringBootApplication.class, args);
	}
	/**
	 *  设置允许所有的访问
	 * @return
	 * @author julong
	 * @date 2021年09月22日 22:25:14
	 * @desc
	 */
//	@Configuration
//	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().anyRequest().permitAll()
//					.and().csrf().disable();
//		}
//	}
}
