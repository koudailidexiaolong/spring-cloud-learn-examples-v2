package com.julong.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.julong.service.dto.UserDTO;

@RestController
public class UserAction {

	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

	@Autowired
    private RestTemplate restTemplate;

	/**
	 * 轮询服务对象
	 * @author julong
	 * @date 2021年09月27日 16:29:29
	 * @desc
	 */
	@Autowired
	private LoadBalancerClient ribbonLoadBalancerClient;

	/**
	 * 查询列表
	 * @return
	 * @author julong
	 * @date 2021年9月23日 下午6:07:05
	 * @desc
	 */
	@RequestMapping(value = "/template/user")
	public ResponseEntity<Object> getUser() {
		logger.info("【用户模块】-查询所有信息");
        ResponseEntity<Object> responseEntity = this.restTemplate.getForEntity("http://spring-cloud-learn-examples-v2-ribbon-server/user",Object.class);
		return responseEntity;
	}

	@RequestMapping(value = "/template/user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") String id) {
		logger.info("【用户模块】-查询单个用户信息 id:{}",id);
        ResponseEntity<UserDTO> responseEntity = this.restTemplate.getForEntity("http://spring-cloud-learn-examples-v2-ribbon-server/user/{id}",UserDTO.class,id);
        //获取服务信息
		ServiceInstance serviceInstance = this.ribbonLoadBalancerClient.choose("spring-cloud-learn-examples-v2-ribbon-server");
		logger.info("serviceInstance:{},host:{},port:{}，URI：{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
		return responseEntity;
	}
	/**
	 * 更新用户信息
	 * @param id
	 * @param user
	 * @return org.springframework.http.ResponseEntity<java.lang.Object>
	 * @author julong
	 * @date 2021年09月26日 14:56:14
	 * @desc
	 */
	@RequestMapping(value = "/template/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody UserDTO user) {
		logger.info("【用户模块】-更新用户信息：id:{}",id);
        this.restTemplate.put("http://spring-cloud-learn-examples-v2-ribbon-server/user/{id}",id , user);
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
	@RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		logger.info("【用户模块】-删除用户信息：id:{}",id);
        this.restTemplate.delete("http://spring-cloud-learn-examples-v2-ribbon-server/user/{id}",id);
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
	@RequestMapping(value = "/template/user", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
		logger.info("【用户模块】-新增用户信息：user:{}",user);
        ResponseEntity<UserDTO> responseEntity =  this.restTemplate.postForEntity("http://spring-cloud-learn-examples-v2-ribbon-server/user",user,UserDTO.class);
		return responseEntity;
	}

}
