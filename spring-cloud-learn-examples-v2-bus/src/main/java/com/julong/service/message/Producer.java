package com.julong.service.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 * @author julong
 * @date 2021年9月29日 下午2:18:04
 * @desc 
 */
@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplateImpl;
	
	/**
	 * 发送消息
	 * @author julong
	 * @date 2021年9月29日 下午2:19:48
	 * @desc
	 */
	public void send(){
		System.out.println("生产者：Hello spring-boot-bus !");
		this.rabbitTemplateImpl.convertAndSend("spring-boot-bus", "Hello spring-boot-bus !");
	}

}
