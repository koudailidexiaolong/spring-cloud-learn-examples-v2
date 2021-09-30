package com.julong.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAction {

	@RequestMapping("/")
	public String home() {
		return "Hello Spring Boot 2.0.0 zuul !";
	}
}
