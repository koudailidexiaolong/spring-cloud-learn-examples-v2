package com.julong.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julong.service.UserService;
import com.julong.service.dto.UserDTO;

@RestController
public class UserAction {

	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;

	/**
	 * 查询列表
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:07:05
	 * @desc
	 */
	@RequestMapping(value = "/user")
	public ResponseEntity<Object> getUser() {
		logger.info("【用户模块】-查询所有信息");
		return new ResponseEntity<>(this.userService.getUserList(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") String id) {
		logger.info("【用户模块】-查询单个用户信息 id:{}",id);
		return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
	}
	/**
	 * 更新用户信息
	 * @param id
	 * @param user
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:07:13
	 * @desc
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody UserDTO user) {
		logger.info("【用户模块】-更新用户信息：id:{}",id);
		this.userService.updateUser(id, user);
		return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:07:22
	 * @desc
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		logger.info("【用户模块】-删除用户信息：id:{}",id);
		this.userService.deleteUser(id);
		return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	}
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:07:29
	 * @desc
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Object> saveUser(@RequestBody UserDTO user) {
		logger.info("【用户模块】-新增用户信息：user:{}",user);
		this.userService.saveUser(user);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}


}
