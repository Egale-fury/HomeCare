package com.eagle.community.user.service;

import com.eagle.community.user.entity.Child;
import com.eagle.community.user.entity.User;

public interface UserService {

	//创建一个用户信息实体类
	public User createUser(User user);
	
	//身份验证
	public User authenticate(String id,String password);
	
	//更新用户信息
	public User updateUser(User user);
	
	public User findUserById(String id);
	
	public User addChildForUser(String id,Child childs);
	
}
