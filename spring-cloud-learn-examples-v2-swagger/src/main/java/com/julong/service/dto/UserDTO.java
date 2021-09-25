package com.julong.service.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户对象
 * @author julong
 * @date 2021年9月23日 下午5:51:07
 * @desc 
 */
@ApiModel(value="UserDTO",description="用户信息实体类@ApiModel用于对实体对象的注解描述") //@ApiModel用于对实体对象的注解描述
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
	@ApiModelProperty(name="id",value="用户编号",dataType="java.lang.String",allowEmptyValue=false)
	private String id;
	/**
	 * 姓名
	 * @author julong
	 * @date 2021年9月23日 下午5:50:49
	 */
	@ApiModelProperty(name="name",value="用户姓名",dataType="java.lang.String",allowEmptyValue=true)
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
