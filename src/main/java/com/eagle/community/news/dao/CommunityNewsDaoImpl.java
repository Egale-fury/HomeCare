package com.eagle.community.news.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.news.entity.CommunityNews;

@Repository("communityNewsDao")
public class CommunityNewsDaoImpl extends BaseDaoImpl<CommunityNews, Long>
		implements CommunityNewsDao {

	//一次性获得多少
	@Override
	public List<CommunityNews> getNews(int size) {
		Criteria criteria =createCriteria();
		orderDesc(criteria, "date", true);
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return criteria.list();
	}
	

	
}
