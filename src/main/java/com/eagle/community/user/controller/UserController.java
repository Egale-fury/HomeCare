package com.eagle.community.user.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.user.entity.Child;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	private static final Logger logger = LogManager
			.getLogger(BaseDaoImpl.class);

	// 根据用户id查找一个用户，并返回json数据
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User getUserJson(@PathVariable("id") String id) {
		logger.info("getUserJson method is invoked ");
		User user = userService.findUserById(id);
		return user;
	}

	// 根据用户id查找一个用户，并返回视图
	@RequestMapping(value = "/{id}")
	public ModelAndView getUser(@PathVariable("id") String id) {
		logger.info("getUser method is invoked ");
		User user = userService.findUserById(id);
		ModelAndView view = new ModelAndView("");//这里调用这个方法的场景是管理员查看用户的详细信息
		view.addObject("userDetail", user);
		return view;
	}

	// 创建一个新用户的请求
	@RequiresRoles("admin")
	@RequestMapping(value="/create",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User createUser(@RequestBody User user) {
		user.setBitrhday(new Date(System.currentTimeMillis()));
		User temp = userService.createUser(user);
		return temp;
	}

	// 更新一个已有的用户信息的
	@RequiresRoles("admin")
	@RequestMapping(value = "/update", method = RequestMethod.POST)// 没有使用put是因为不同浏览器支持的原因
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateUser(@RequestBody User user) {
		User temp = userService.updateUser(user);
		return temp;
	}

	// 为某个用户添加子女信息
	@RequiresRoles("admin")
	@RequestMapping(value = "/{id}/addChild", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User addChild(@PathVariable("id") String id,
			@RequestBody Child childs) {
		return userService.addChildForUser(id, childs);
	}

	// 修改某个用户的某个子女的信息
	@RequiresRoles("admin")
	@RequestMapping(value = "/{id}/updateChild", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateChild(@PathVariable("id") String id,
			@RequestBody Child childs) {
		User user = userService.updateChildForUser(id, childs);
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserServcie(UserService userServcie) {
		this.userService = userServcie;
	}

}
