package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 接口文档服务
 * @author julong
 * @date 2021年9月23日 下午6:42:32
 * @desc 
 */
@SpringBootApplication
@EnableSwagger2
public class SwaggerSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(SwaggerSpringBootApplication.class, args);
	}

	@Bean
	public Docket getUserApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("spring boot 集成 swagger2 实现接口api") //文档标题
						.version("1.0.0") //版本
						.contact(new Contact("julong", "www.julong.com", "julong@qq.com")) //作者信息
						.description("spring boot 集成 swagger2 实现接口api 服务") //接口描述信息
						.build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.julong.action")) //扫描的包
				.paths(PathSelectors.any()) //扫描路径
				.build();
	}
	

}
