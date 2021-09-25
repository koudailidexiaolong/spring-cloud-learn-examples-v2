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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "用户模块")
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
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ApiOperation(value = "查询用户信息列表")
	public ResponseEntity<Object> getUser() {
		logger.info("【用户模块】-查询所有信息");
		return new ResponseEntity<>(this.userService.getUserList(), HttpStatus.OK);
	}
	
	/**
	 * 根据编号获取单个用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午10:23:54
	 * @desc paramType 参数来源类型 path, query, body, header or form.
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据编号查询用户信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",allowEmptyValue=false,required=true)
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
	@ApiOperation(value = "根据编号更新用户信息")
	@ApiImplicitParams(value={
			@ApiImplicitParam(name="id",value="用户编号",paramType="path",allowEmptyValue=false,required=true),
			@ApiImplicitParam(name="user",value="用户对象",paramType="body",allowEmptyValue=false,required=true)
	})
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
	@ApiOperation(value = "根据编号删除用户信息")
	@ApiImplicitParam(name="id",value="用户编号",paramType="path",allowEmptyValue=false,required=true)
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
	@ApiOperation(value = "新增用户信息")
	@ApiImplicitParam(name="user",value="用户对象",paramType="body",allowEmptyValue=false,required=true)
	public ResponseEntity<Object> saveUser(@RequestBody UserDTO user) {
		logger.info("【用户模块】-新增用户信息：user:{}",user);
		this.userService.saveUser(user);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}


}
