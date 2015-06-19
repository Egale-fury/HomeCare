package com.eagle.community.news.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eagle.community.news.dao.CommunityNewsDao;
import com.eagle.community.news.entity.CommunityNews;

/*
 * @author dpc
 * @2016.6.16
 * 
 * */

@Service("communityNewsService")
@Transactional
public class CommunityNewServiceImpl implements CommunityNewsService {

	@Resource
	private CommunityNewsDao communityNewsDao;

	@Override
	public CommunityNews saveNews(CommunityNews news) {
		int id =communityNewsDao.save(news);
		return communityNewsDao.find(id);
	}

	@Override
	public CommunityNews updateNews(CommunityNews news) {
		CommunityNews temp = communityNewsDao.find(news.getId());
		temp.setTitle(news.getTitle());
		temp.setAuthorName(news.getAuthorName());
		temp.setArticle(news.getArticle());
		temp.setCount(news.getCount());

		communityNewsDao.update(temp);
		return temp;
	}

	@Override
	public CommunityNews getNewsById(int id) {
		return communityNewsDao.find(id);
	}

	@Override
	public boolean deleteNews(CommunityNews news) {
		communityNewsDao.delete(news);
		return true;
	}

	@Override
	public int getTotalCount() {
		return communityNewsDao.getTotalCount();
	}

	@Override
	public List<CommunityNews> getAllNews() {
		return communityNewsDao.getAll();
	}

	public CommunityNewsDao getCommunityNewsDao() {
		return communityNewsDao;
	}

	public void setCommunityNewsDao(CommunityNewsDao communityNewsDao) {
		this.communityNewsDao = communityNewsDao;
	}

}
