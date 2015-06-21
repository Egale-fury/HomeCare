package com.eagle.community.user.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.user.entity.Child;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userServcie;

	private static final Logger logger = LogManager
			.getLogger(BaseDaoImpl.class);

	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User getUserJson(@PathVariable("id") String id) {
		logger.info("getUserJson method is invoked ");
		User user = userServcie.findUserById(id);
		return user;
	}

	// 创建一个新用户的请求
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User createUser(@RequestBody User user) {
		user.setBitrhday(new Date(System.currentTimeMillis()));
		User temp = userServcie.createUser(user);
		return temp;
	}

	// 更新一个已有的用户信息的
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	// 没有使用put是因为不同浏览器支持的原因
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateUser(@RequestBody User user) {
		User temp = userServcie.updateUser(user);
		return temp;
	}

	// 为某个用户添加子女信息
	@RequestMapping(value = "/{id}/addChild", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User addChild(@PathVariable("id") String id,
			@RequestBody Child childs) {
		return userServcie.addChildForUser(id, childs);
	}

	// 修改某个用户的某个子女的信息
	@RequestMapping(value = "/{id}/updateChild", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateChild(@PathVariable("id") String id, @RequestBody Child childs) {
		User user =userServcie.updateChildForUser(id, childs);
		return user;
	}

	public UserService getUserServcie() {
		return userServcie;
	}

	public void setUserServcie(UserService userServcie) {
		this.userServcie = userServcie;
	}

}
