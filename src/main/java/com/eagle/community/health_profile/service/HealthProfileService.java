package com.eagle.community.health_profile.service;

import com.eagle.community.health_profile.entity.HealthProfile;
import com.eagle.community.user.entity.User;

public interface HealthProfileService{

	//为一个用户增添健康档案信息
	public HealthProfile addHealthProfile(String userId,HealthProfile healthProfile);
	
	//根据用户id查找其健康档案信息
	public HealthProfile getHealthProfile(String userId);
	
	//为某个用户更新健康档案信息
	public String updateHealthProfile(HealthProfile healthProfile);
	
	//
}
