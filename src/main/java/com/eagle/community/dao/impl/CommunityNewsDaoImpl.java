package com.eagle.community.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.dao.CommunityNewsDao;
import com.eagle.community.model.CommunityNews;

@Repository("communityNewsDao")
public class CommunityNewsDaoImpl extends BaseDaoImpl<CommunityNews, Integer>
		implements CommunityNewsDao {
	

}
