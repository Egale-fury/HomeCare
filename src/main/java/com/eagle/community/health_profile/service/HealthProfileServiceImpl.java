package com.eagle.community.health_profile.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.health_profile.dao.HealthProfileDao;
import com.eagle.community.health_profile.entity.HealthProfile;
import com.eagle.community.health_profile.exception.DuplicateHealthProfileException;
import com.eagle.community.health_profile.exception.HealthProfileNotFoundException;
import com.eagle.community.service.BaseService;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

@Service
@Transactional
public class HealthProfileServiceImpl extends BaseService implements
		HealthProfileService {

	@Resource
	private HealthProfileDao healthProfileDao;
	
	@Resource
	private UserService userService;
	
	private static final Logger logger = LogManager
			.getLogger(HealthProfileServiceImpl.class);
	
	@Override
	public HealthProfile addHealthProfile(String userId,HealthProfile healthProfile) {
		validate(healthProfile);
		User user= userService.findUserById(userId);
		if(user.getHealthProfile()!=null){
			logger.info("用户的健康档案已经存在！");
			throw new DuplicateHealthProfileException();
		}else{
			logger.info("用户健康档案尚未创建，准备创建中...");
			user.setHealthProfile(healthProfile);
			healthProfile.setUser(user);
			String id=healthProfileDao.save(healthProfile);
			return healthProfileDao.find(id);
		}
	}
	
	@Override
	public HealthProfile getHealthProfile(String userId) {
		User user =userService.findUserById(userId);
		if(user.getHealthProfile()!=null){
			logger.info("找到用户健康档案，准备返回");
			return user.getHealthProfile();
		}else{
			logger.info("用户健康还未创建！");
			throw new HealthProfileNotFoundException();
		}
	}
	
	@Override
	public String updateHealthProfile(
			HealthProfile healthProfile) {
		validate(healthProfile);
		healthProfileDao.update(healthProfile);
		return healthProfile.getUser().getId();
	}


	public HealthProfileDao getHealthProfileDao() {
		return healthProfileDao;
	}

	public void setHealthProfileDao(HealthProfileDao healthProfileDao) {
		this.healthProfileDao = healthProfileDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	
}
