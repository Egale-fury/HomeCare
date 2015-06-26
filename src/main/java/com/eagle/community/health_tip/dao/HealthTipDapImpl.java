package com.eagle.community.health_tip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.health_tip.entity.HealthTip;

@Repository("healthTipDao")
public class HealthTipDapImpl extends BaseDaoImpl<HealthTip,Long> implements HealthTipDao{

	
	//一次性获得多少条
	@Override
	public List<HealthTip> getTips(int size) {
		Criteria criteria =createCriteria();
		orderDesc(criteria, "releaseTime", true);
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return criteria.list();
	}

}
