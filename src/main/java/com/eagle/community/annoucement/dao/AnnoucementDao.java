package com.eagle.community.annoucement.dao;

import java.util.List;

import com.eagle.community.annoucement.entity.Annoucement;
import com.eagle.community.dao.BaseDao;

/*
 * 底层通知公告的dao接口
 * */
public interface AnnoucementDao extends BaseDao<Annoucement,Long>{

	//一次性获得指定条数的通知公告
	public List<Annoucement> getAnnoucements(int size);
}
