package com.eagle.community.health_profile.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.health_profile.entity.HealthProfile;
import com.eagle.community.user.entity.User;

@Repository
public class HealthProfileDaoImpl extends BaseDaoImpl<HealthProfile, String> implements HealthProfileDao{

	@Override
	public HealthProfile getProfileByUser(User user) {
		Criteria criteria =createCriteria();
		criteria.add(Restrictions.eq("user", user));
		
		return (HealthProfile)criteria.uniqueResult();
	}

}
