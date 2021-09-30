package com.julong.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julong.service.dto.UserDTO;

/**
 * 用户模块
 * @author julong
 * @date 2021年9月23日 下午5:52:56
 * @desc  @FeignClient 通过此参数来绑定服务调用的名称
 */
@FeignClient(name="spring-cloud-learn-examples-v2-eureka-client") 
public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:53:57
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public abstract void saveUser(@RequestBody UserDTO user);
	
	/**
	 * 更新用户
	 * @param id
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:54:09
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
	public abstract void updateUser(@PathVariable("id") String id, @RequestBody UserDTO user);
	/**
	 * 删除用户
	 * @param id
	 * @author julong
	 * @date 2021年9月23日 下午5:54:16
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public abstract void deleteUser(@PathVariable("id") String id);
	/**
	 * 查询用户集合
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午5:54:22
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public abstract Collection<UserDTO> getUserList();
	
	/**
	 * 获取单个用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:21:59
	 * @desc
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public abstract UserDTO getUser(@PathVariable("id") String id);

}
