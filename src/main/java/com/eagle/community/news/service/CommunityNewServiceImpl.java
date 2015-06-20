package com.eagle.community.news.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.news.dao.CommunityNewsDao;
import com.eagle.community.news.entity.CommunityNews;
import com.eagle.community.news.exception.DuplicateNewsException;
import com.eagle.community.news.exception.NewsNotFoundException;

/*
 * @author dpc
 * @2016.6.16
 * 
 * */

@Service("communityNewsService")
@Transactional
public class CommunityNewServiceImpl implements CommunityNewsService {

	private static final Logger logger = LogManager
			.getLogger(CommunityNewServiceImpl.class);

	@Resource
	private CommunityNewsDao communityNewsDao;

	@Override
	public CommunityNews saveNews(CommunityNews news) {
		CommunityNews temp = communityNewsDao.find(news.getId());
		if (temp != null) {
			logger.info("communityNews already exists ,cannot create again !");
			throw new DuplicateNewsException();
		} else {
			logger.info("preapare to create a new communityNews ");
			long id = communityNewsDao.save(news);
			return communityNewsDao.find(id);
		}
	}

	@Override
	public CommunityNews updateNews(CommunityNews news) {
		CommunityNews temp = communityNewsDao.find(news.getId());
		if (temp != null) {
			temp.setTitle(news.getTitle());
			temp.setAuthorName(news.getAuthorName());
			temp.setArticle(news.getArticle());
			temp.setCount(news.getCount());

			communityNewsDao.update(temp);
			return temp;
		} else {
			logger.info("the communityNews does not exist!!");
			throw new NewsNotFoundException();
		}
	}

	@Override
	public CommunityNews getNewsById(long id) {
		CommunityNews temp = communityNewsDao.find(id);
		if (temp != null) {
			return temp;
		} else {
			logger.info("the communityNews does not exists yet !");
			throw new NewsNotFoundException();
		}
	}

	@Override
	public boolean deleteNews(CommunityNews news) {
		CommunityNews temp = communityNewsDao.find(news.getId());
		if (temp != null) {
			communityNewsDao.delete(news);
			return true;
		} else {
			logger.info("the communityNews was to delete does not exist !");
			throw new NewsNotFoundException();
		}
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
