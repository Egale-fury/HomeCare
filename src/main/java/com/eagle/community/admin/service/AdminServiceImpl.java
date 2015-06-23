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
import com.eagle.community.service.BaseService;

@Service("adminService")
public class AdminServiceImpl extends BaseService implements AdminService  {

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
		validate(admin);
		adminDao.update(admin);
		return admin;
	}
	
	

}
