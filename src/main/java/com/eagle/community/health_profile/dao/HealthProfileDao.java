package com.eagle.community.health_profile.dao;

import com.eagle.community.dao.BaseDao;
import com.eagle.community.health_profile.entity.HealthProfile;
import com.eagle.community.user.entity.User;

public interface HealthProfileDao extends BaseDao<HealthProfile, String>{
	
	public HealthProfile getProfileByUser(User user);
}
