package com.eagle.community.admin.service;

import com.eagle.community.admin.entity.Admin;

//管理员信息服务接口
public interface AdminService {

	//验证管理员用户
	public Admin authenticate(String userName,String password);
	
	//更新管理员信息
	public Admin updateAdminInfo(Admin admin);
}
