package com.julong.service;

import java.util.Collection;

import com.julong.service.dto.UserDTO;

/**
 * 用户模块
 * @author julong
 * @date 2021年9月23日 下午5:52:56
 * @desc 
 */
public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:53:57
	 * @desc
	 */
	public abstract void saveUser(UserDTO user);
	
	/**
	 * 更新用户
	 * @param id
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:54:09
	 * @desc
	 */
	public abstract void updateUser(String id, UserDTO user);
	/**
	 * 删除用户
	 * @param id
	 * @author julong
	 * @date 2021年9月23日 下午5:54:16
	 * @desc
	 */
	public abstract void deleteUser(String id);
	/**
	 * 查询用户集合
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午5:54:22
	 * @desc
	 */
	public abstract Collection<UserDTO> getUserList();
	
	/**
	 * 获取单个用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:21:59
	 * @desc
	 */
	public abstract UserDTO getUser(String id);

}
