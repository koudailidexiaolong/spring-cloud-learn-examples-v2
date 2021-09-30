package com.julong.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class IndexAction {

	@Value("${welcome.message}")
	private String message;

	@RequestMapping("/")
	public String home() {
		return "Hello Spring Boot 2.0.9 " + message;
	}
}
