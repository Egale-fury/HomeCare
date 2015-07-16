package com.eagle.community.cultural_recreation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.cultural_recreation.entity.RecreationInfo;
import com.eagle.community.dao.BaseDaoImpl;

/*文化娱乐dao接口的具体实现*/
@SuppressWarnings("unchecked")
@Repository("recreationInfoDao")
public class RecreationInfoDaoImpl extends BaseDaoImpl<RecreationInfo, Long>
		implements RecreationInfoDao {

	@Override
	public List<RecreationInfo> getSome(int size) {
		Criteria criteria =createCriteria();
		orderDesc(criteria,"releaseTime" ,true);
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return (List<RecreationInfo>)criteria.list();
	}

	@Override
	public List<RecreationInfo> searchWithKeyWords(String keyWords) {
		Criteria criteria =createCriteria();
		orderDesc(criteria, "releaseTime", true);
		criteria.add(Restrictions.like("keyWords", keyWords+"%"));
		return (List<RecreationInfo>)criteria.list();
	}

	
}
