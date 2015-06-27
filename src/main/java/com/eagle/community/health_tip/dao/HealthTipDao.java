package com.eagle.community.health_tip.dao;

import java.util.List;

import com.eagle.community.dao.BaseDao;
import com.eagle.community.health_tip.entity.HealthTip;

public interface HealthTipDao extends BaseDao<HealthTip,Long>{

	//返回相应条数的健康贴士，默认按发布时间降序
	public List<HealthTip> getTips(int size);
}
