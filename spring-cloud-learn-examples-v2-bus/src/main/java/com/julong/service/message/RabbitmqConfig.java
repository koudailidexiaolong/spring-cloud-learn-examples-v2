package com.julong.service.message;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	@Bean
	public Queue getQueue(){
		return new Queue("spring-boot-bus");
	}
}
