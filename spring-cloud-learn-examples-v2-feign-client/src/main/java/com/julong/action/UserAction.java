package com.julong.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julong.service.UserService;
import com.julong.service.dto.UserDTO;

@RestController
public class UserAction {

	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public UserDTO getUser(@PathVariable("id") String id){
		return this.userServiceImpl.getUser(id);
	}
}
