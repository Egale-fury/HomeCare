package com.eagle.community.news.dao;

import java.util.List;

import com.eagle.community.dao.BaseDao;
import com.eagle.community.news.entity.CommunityNews;


public interface CommunityNewsDao extends BaseDao<CommunityNews,Long>{
	
	//返回相应条数的communityNews,默认按日期降序
	public List<CommunityNews> getNews(int size);
	
}
