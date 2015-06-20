package com.eagle.community.news.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.eagle.community.news.dao.CommunityNewsDao;
import com.eagle.community.news.entity.CommunityNews;
import com.eagle.community.news.entity.Pagination;
import com.eagle.community.news.exception.DuplicateNewsException;
import com.eagle.community.news.exception.NewsNotFoundException;
import com.eagle.community.news.exception.NoNewsException;

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
			communityNewsDao.update(news);
			return news;
		
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

	// 一次性获得指定的条数的发布时间最晚的size条新闻
	@Override
	public List<CommunityNews> getNews(int size) {
		List<CommunityNews> list = communityNewsDao.getNews(size);
		if (list.size() == 0) {
			logger.info("暂时还没有添加社区动态消息");
			throw new NoNewsException();
		}
		return list;
	}

	// 带分页获得某一页的社区动态新闻
	@Override
	public Pagination getNews(int currentPage, int pageSize,
			boolean desc) {
		int totalCount =getTotalCount();
		Pagination pagination=new Pagination(currentPage,pageSize,totalCount);
		List<CommunityNews> list = communityNewsDao.list(currentPage, pageSize,
				desc);
		if (list.size() == 0) {
			logger.info("暂时还没有添加社区动态消息");
			throw new NoNewsException();
		} else{
			pagination.setTotalPages(totalCount%pageSize+1);
			pagination.setNews(list);
			return pagination;
		}
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
