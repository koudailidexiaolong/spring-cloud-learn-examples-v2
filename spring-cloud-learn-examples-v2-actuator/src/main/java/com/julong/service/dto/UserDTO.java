package com.julong.service.dto;

import java.io.Serializable;

/**
 * 用户对象
 * @author julong
 * @date 2021年9月23日 下午5:51:07
 * @desc 
 */
public class UserDTO implements Serializable{
	/**
	 * @author julong
	 * @date 2021年9月23日 下午5:51:16
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 * @author julong
	 * @date 2021年9月23日 下午5:50:43
	 */
	private String id;
	/**
	 * 姓名
	 * @author julong
	 * @date 2021年9月23日 下午5:50:49
	 */
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + "]";
	}


}
