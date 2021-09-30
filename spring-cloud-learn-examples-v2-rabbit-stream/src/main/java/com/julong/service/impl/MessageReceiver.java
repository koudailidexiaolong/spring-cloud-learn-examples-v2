package com.julong.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 消息接受者
 * @author julong
 * @date 2021年9月29日 下午9:00:05
 * @desc 
 */
@EnableBinding(value={Sink.class})
public class MessageReceiver {

	@StreamListener(Sink.INPUT)
	public void receiver(Object payload){
		System.out.println("消息接收者也是消费者"+payload);
		try {
			System.out.println(new ObjectMapper().writeValueAsString(payload));
		
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
