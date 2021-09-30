package com.julong.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.julong.service.UserService;
import com.julong.service.dto.UserDTO;

/**
 * 用户模块
 * @author julong
 * @date 2021年9月23日 下午6:02:01
 * @desc 
 */
@Service
public class UserServiceImpl implements UserService{

	private static Map<String, UserDTO> userRepo = new HashMap<>();
	static {
		for (int i = 1; i < 5; i++) {
			UserDTO user = new UserDTO();
			user.setId(i+"");
			user.setName("julong-"+i);
			userRepo.put(user.getId(), user);
		}

	}


	/**
	 * 新增用户
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:53:57
	 * @desc
	 */
	@Override
	public void saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		userRepo.put(user.getId(), user);
	}
	/**
	 * 更新用户
	 * @param id
	 * @param user
	 * @author julong
	 * @date 2021年9月23日 下午5:54:09
	 * @desc
	 */
	@Override
	public void updateUser(String id, UserDTO user) {
		// TODO Auto-generated method stub
		userRepo.remove(id);
		user.setId(id);
		userRepo.put(id, user);


	}
	/**
	 * 删除用户
	 * @param id
	 * @author julong
	 * @date 2021年9月23日 下午5:54:16
	 * @desc
	 */
	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepo.remove(id);
	}
	/**
	 * 查询用户集合
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午5:54:22
	 * @desc
	 */
	@Override
	public Collection<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		 return userRepo.values();
	}
	/**
	 * 获取单个用户信息
	 * @param id
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:21:59
	 * @desc
	 */
	@Override
	public UserDTO getUser(String id) {
		// TODO Auto-generated method stub
		 return userRepo.get(id);
	}

	
	
}
