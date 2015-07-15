package com.eagle.community.annoucement.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.annoucement.dao.AnnoucementDao;
import com.eagle.community.annoucement.entity.Annoucement;
import com.eagle.community.annoucement.entity.Pagination;
import com.eagle.community.annoucement.exception.AnnoucementNotFoundException;
import com.eagle.community.news.exception.NoNewsException;
import com.eagle.community.service.BaseService;

/*
 * 继承自基础service的通知公告接口的具体实现
 * 引用AnnoucementDao 接口的一个上转型对象
 * */

@Service("annoucementService")
@Transactional
public class AnnoucementServiceImpl extends BaseService implements
		AnnoucementService {

	@Resource
	private AnnoucementDao annoucementDao;

	private static final Logger logger = LogManager
			.getLogger(AnnoucementServiceImpl.class);

	@Override
	public Annoucement addAnnoucement(Annoucement an) {
		logger.info("validate annoucement");
		validate(an);
		logger.info("prepare to create an new annoucement....");
		Long id = annoucementDao.save(an);
		return annoucementDao.find(id);
	}

	@Override
	public Annoucement getAnnoucement(long id) {
		return annoucementDao.find(id);
	}

	@Override
	public Annoucement updateAnnoucement(Annoucement an) {
		validate(an);
		annoucementDao.update(an);
		return an;
	}

	@Override
	public boolean deleteAnnoucement(long id) {
		Annoucement temp = annoucementDao.find(id);
		if(temp!=null){
			annoucementDao.delete(temp);
			return true;
		}else{
			logger.info("准备删除的通知公告不存在");
			throw new AnnoucementNotFoundException();//跳转到Advice执行
		}
	}

	@Override
	public Pagination getOnePageAC(int currentPage, int pageSize, boolean desc) {
		int totalCount = getTotalCount();
		Pagination pagination = new Pagination(currentPage, pageSize,
				totalCount);
		List<Annoucement> list =annoucementDao.list(currentPage, pageSize, desc);
		if (list.size() == 0) {
			logger.info("暂时还未有通知公告");
			throw new NoNewsException();
		} else {
			if (totalCount % pageSize == 0) {
				pagination.setTotalPages(totalCount / pageSize );
			} else {
				pagination.setTotalPages(totalCount / pageSize+1 );
			}
			pagination.setAnnoucements(list);
			return pagination;
			
		}
	}
	
	@Override
	public int getTotalCount() {
		return annoucementDao.getTotalCount();
	}

	@Override
	public List<Annoucement> getAnnoucements(int size) {
		return annoucementDao.getAnnoucements(size);
	}

	@Override
	public List<Annoucement> getAll() {
		return annoucementDao.getAll();
	}

	public AnnoucementDao getAnnoucementDao() {
		return annoucementDao;
	}

	public void setAnnoucementDao(AnnoucementDao annoucementDao) {
		this.annoucementDao = annoucementDao;
	}


}
