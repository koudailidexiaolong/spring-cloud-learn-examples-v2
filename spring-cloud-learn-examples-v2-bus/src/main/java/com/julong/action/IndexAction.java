package com.julong.action;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@Autowired
	private RabbitTemplate rabbitTemplateImpl;
	
	@RequestMapping("/")
	public String home() {
		this.rabbitTemplateImpl.convertAndSend("spring-boot-bus","Hello Spring Boot bus 2.0.0 !");
		System.out.println(this.rabbitTemplateImpl.getExchange());
		return "Hello Spring Boot 2.0.0 !";
	}
}
