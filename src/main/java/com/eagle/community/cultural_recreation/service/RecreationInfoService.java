package com.eagle.community.cultural_recreation.service;

import java.util.List;

import com.eagle.community.cultural_recreation.entity.Pagination;
import com.eagle.community.cultural_recreation.entity.RecreationInfo;

/*负责文化娱乐信息的service接口*/
public interface RecreationInfoService {

	/*CRUD基础操作*/
	
	//添加一条文化娱乐类信息
	public RecreationInfo addRecreationInfo(RecreationInfo info);
	
	//根据id查找并返回一条文化娱乐类信息
	public RecreationInfo getRecreationInfo(long id);
	
	//更新一条已经存在的文化娱乐类信息
	public RecreationInfo updateInfo(RecreationInfo info);
	
	//根据id删除一条已经存在的文化娱乐类信息
	public boolean deleteInfo(long id);
	
	public List<RecreationInfo> getAll();
	
	public List<RecreationInfo> getSome(int size);
	
	public Pagination getOnPageInfo(int currentPage, int pageSize, boolean desc);
	
	public int getTotalCount();
	
	public List<RecreationInfo> search(String keyWords);
 }
