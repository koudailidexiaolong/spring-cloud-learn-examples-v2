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


	/**
	 * 编号
	 * @author julong
	 * @date 2021年9月23日 下午5:50:43
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 编号
	 * @author julong
	 * @date 2021年9月23日 下午5:50:43
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 姓名
	 * @author julong
	 * @date 2021年9月23日 下午5:50:49
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 姓名  @author julong  @date 2021年9月23日 下午5:50:49
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("UserDTO{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
