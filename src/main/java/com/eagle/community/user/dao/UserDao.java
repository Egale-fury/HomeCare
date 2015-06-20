package com.eagle.community.user.dao;

import com.eagle.community.dao.BaseDao;
import com.eagle.community.user.entity.User;

public interface UserDao extends BaseDao<User,String>{

	public User authenticate(String id,String password);
	
}
