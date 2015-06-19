package com.eagle.community.news.service;

import java.util.List;

import com.eagle.community.news.entity.CommunityNews;

/*
 * @author dpc
 * @2015.6.16
 * @ interface of communityNewsService
 * */
public interface CommunityNewsService {

	//保存一条社区动态
	public CommunityNews saveNews(CommunityNews news);
	
	//更新一条社区动态信息
	public CommunityNews updateNews(CommunityNews news);
	
	//更具id查询某一条具体的news
	public CommunityNews getNewsById(int id);
	
	//删除一条社区动态消息
	public boolean deleteNews(CommunityNews news);
	
	//获得所有社区动态的条数
	public int getTotalCount();
	
	//获得所有的社区动态消息
	public List<CommunityNews> getAllNews();
}
