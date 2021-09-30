package com.julong.service.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author julong
 * @date 2021年9月29日 下午2:20:35
 * @desc 
 */
@Component
@RabbitListener(queues="spring-boot-bus")
public class Consumer {

	@RabbitHandler
	public void process(String messages){
		System.out.println("消费者："+messages);
	}
}
