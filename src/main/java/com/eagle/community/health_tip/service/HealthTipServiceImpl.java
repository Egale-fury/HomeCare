package com.eagle.community.health_tip.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.health_tip.dao.HealthTipDao;
import com.eagle.community.health_tip.entity.HealthTip;
import com.eagle.community.health_tip.entity.Pagination;
import com.eagle.community.health_tip.exception.DuplicateHealthTipException;
import com.eagle.community.health_tip.exception.HealthTipNotFoudException;
import com.eagle.community.health_tip.exception.NoTipsException;
import com.eagle.community.service.BaseService;

@Service("healthTipService")
@Transactional
public class HealthTipServiceImpl extends BaseService implements
		HealthTipService {

	private static final Logger logger = LogManager
			.getLogger(HealthTipServiceImpl.class);

	@Resource(name = "healthTipDao")
	private HealthTipDao healthTipDao;

	@Override
	public HealthTip addTip(HealthTip tip) {
		logger.info("validate tip");
		validate(tip);
		HealthTip temp = healthTipDao.find(tip.getId());
		if (temp != null) {
			logger.info("健康贴士已经存在");
			throw new DuplicateHealthTipException();
		} else {
			long id = healthTipDao.save(tip);
			return healthTipDao.find(id);
		}
	}

	@Override
	public boolean deleteTip(HealthTip tip) {
		HealthTip temp = healthTipDao.find(tip.getId());
		if (temp != null) {
			healthTipDao.delete(temp);
			return true;
		} else {
			logger.info("the healthTip was to delete does not exist !");
			throw new HealthTipNotFoudException();
		}
	}

	@Override
	public HealthTip getTip(long id) {
		HealthTip tip=healthTipDao.find(id);
		if(tip==null){
			logger.info("健康贴士不存在 ");
			throw new HealthTipNotFoudException();
		}else{
			return healthTipDao.find(id);
		}
	}

	@Override
	public HealthTip updateTip(HealthTip tip) {
		validate(tip);
		healthTipDao.update(tip);
		return tip;
	}

	@Override
	public int getTotalCount() {
		return healthTipDao.getTotalCount();
	}

	@Override
	public List<HealthTip> getTips(int size) {
		List<HealthTip> list = healthTipDao.getTips(size);
		if (list.size() == 0) {
			logger.info("暂时还没有添加健康小贴士");
			throw new NoTipsException();
		}
		return list;
	}

	@Override
	public List<HealthTip> getAllTips() {
		return healthTipDao.getAll();
	}

	@Override
	public Pagination getTips(int currentPage, int pageSize, boolean desc) {
		int totalCount = getTotalCount();
		Pagination pagination = new Pagination(currentPage, pageSize,
				totalCount);
		List<HealthTip> list = healthTipDao.list(currentPage, pageSize, desc);
		if (list.size() == 0) {
			logger.info("暂时还没有添加健康小贴士");
			throw new NoTipsException();
		} else {
			if (totalCount % pageSize == 0) {
				pagination.setTotalPages(totalCount / pageSize );
			} else {
				pagination.setTotalPages(totalCount / pageSize+1 );
			}
			pagination.setTips(list);
			return pagination;
		}
	}

	public HealthTipDao getHealthTipDao() {
		return healthTipDao;
	}

	public void setHealthTipDao(HealthTipDao healthTipDao) {
		this.healthTipDao = healthTipDao;
	}

}
