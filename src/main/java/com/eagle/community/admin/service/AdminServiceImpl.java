package com.eagle.community.admin.service;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.admin.dao.AdminDao;
import com.eagle.community.admin.entity.Admin;
import com.eagle.community.admin.exception.AdminNotFoundException;
import com.eagle.community.admin.exception.AuthenticationException;
import com.eagle.community.news.service.CommunityNewServiceImpl;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private static final Logger logger = LogManager
			.getLogger(AdminServiceImpl.class);
	
	@Resource
	private AdminDao adminDao;

	public Admin authenticate(String userName, String password) {
		Admin admin = adminDao.authenticate(userName, password);
		if (admin != null) {
			return adminDao.authenticate(userName, password);
		} else {
			logger.info("该管理员不存在，用户名或密码错误 !");
			throw new AuthenticationException();
		}

	}

	@Override
	public Admin updateAdminInfo(Admin admin) {
		Admin temp =adminDao.find(admin.getId());
		if(temp!=null){
			adminDao.update(admin);
			return admin;
		}else{
			logger.info("该管理员不存在，无法进行修改 !");
			throw new AdminNotFoundException();
		}
	}
	

	
	
}
