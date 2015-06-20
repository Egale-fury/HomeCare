package com.eagle.community.news.dao;

import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.news.entity.CommunityNews;

@Repository("communityNewsDao")
public class CommunityNewsDaoImpl extends BaseDaoImpl<CommunityNews, Long>
		implements CommunityNewsDao {
	

}
