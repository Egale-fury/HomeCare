package com.eagle.community.user.controller;

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
		User user = userServcie.findUserById(id);
		return user;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateUser(@RequestBody User user) {
		User temp = userServcie.createUser(user);
		return temp;
	}

	public UserService getUserServcie() {
		return userServcie;
	}

	public void setUserServcie(UserService userServcie) {
		this.userServcie = userServcie;
	}

}
