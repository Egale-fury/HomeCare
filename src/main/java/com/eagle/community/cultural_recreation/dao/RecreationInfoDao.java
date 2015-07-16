package com.eagle.community.cultural_recreation.dao;

import java.util.List;

import com.eagle.community.cultural_recreation.entity.RecreationInfo;
import com.eagle.community.dao.BaseDao;

/*基础的文化娱乐信息Dao接口*/
public interface RecreationInfoDao extends BaseDao<RecreationInfo, Long>{
	
	//一次获得指定条数的娱乐类信息
	public List<RecreationInfo> getSome(int size);
	
	public List<RecreationInfo> searchWithKeyWords(String keyWords);
}
