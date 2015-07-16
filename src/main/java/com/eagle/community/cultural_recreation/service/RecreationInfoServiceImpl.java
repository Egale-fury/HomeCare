package com.eagle.community.cultural_recreation.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.eagle.community.cultural_recreation.dao.RecreationInfoDao;
import com.eagle.community.cultural_recreation.entity.Pagination;
import com.eagle.community.cultural_recreation.entity.RecreationInfo;
import com.eagle.community.cultural_recreation.exception.NoRecreationInfoException;
import com.eagle.community.cultural_recreation.exception.RecreationInfoNotFoundException;
import com.eagle.community.service.BaseService;

/*文化娱乐类信息service接口的具体实现*/
@Service("recreationInfoService")
@Transactional
public class RecreationInfoServiceImpl extends BaseService implements
		RecreationInfoService {

	@Resource(name="recreationInfoDao")
	private RecreationInfoDao recreationInfoDao;

	private static final Logger logger = LogManager
			.getLogger(RecreationInfoServiceImpl.class);

	@Override
	public RecreationInfo addRecreationInfo(RecreationInfo info) {
		logger.info("validate RecreationInfo ..");
		validate(info);
		logger.info("prepare to create a new RecreationInfo ");
		long id = recreationInfoDao.save(info);
		return recreationInfoDao.find(id);
	}

	@Override
	public RecreationInfo getRecreationInfo(long id) {
		return recreationInfoDao.find(id);
	}

	@Override
	public RecreationInfo updateInfo(RecreationInfo info) {
		validate(info);
		recreationInfoDao.update(info);
		return info;
	}

	@Override
	public boolean deleteInfo(long id) {
		RecreationInfo info = recreationInfoDao.find(id);
		if (info != null) {
			recreationInfoDao.delete(info);
			return true;
		} else {
			logger.info("id为:" + id + "的文化娱乐信息不存在!");
			throw new RecreationInfoNotFoundException();
		}
	}

	@Override
	public List<RecreationInfo> getAll() {
		return recreationInfoDao.getAll();
	}

	@Override
	public List<RecreationInfo> getSome(int size) {
		return recreationInfoDao.getSome(size);
	}

	@Override
	public Pagination getOnPageInfo(int currentPage, int pageSize, boolean desc) {
		int totalCount = getTotalCount();
		Pagination pagination = new Pagination(currentPage, pageSize,
				totalCount);
		List<RecreationInfo> list = recreationInfoDao.list(currentPage,
				pageSize, desc);
		if (list.size() == 0) {
			logger.info("暂时还未有通知公告");
			throw new NoRecreationInfoException();
		} else {
			if (totalCount % pageSize == 0) {
				pagination.setTotalPages(totalCount / pageSize );
			} else {
				pagination.setTotalPages(totalCount / pageSize+1 );
			}
			pagination.setInfo(list);
			return pagination;
			
		}
	}

	public RecreationInfoDao getRecreationInfoDao() {
		return recreationInfoDao;
	}

	public void setRecreationInfoDao(RecreationInfoDao recreationInfoDao) {
		this.recreationInfoDao = recreationInfoDao;
	}

	@Override
	public int getTotalCount() {
		return recreationInfoDao.getTotalCount();
	}

	@Override
	public List<RecreationInfo> search(String keyWords) {
		return recreationInfoDao.searchWithKeyWords(keyWords);
	}


}
