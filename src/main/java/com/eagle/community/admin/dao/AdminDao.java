package com.eagle.community.admin.dao;

import com.eagle.community.admin.entity.Admin;
import com.eagle.community.dao.BaseDao;

public interface AdminDao extends BaseDao<Admin, Integer>{

	public Admin authenticate(String userName,String password);
	
	public Admin getByUserName(String userName);
}
