package com.eagle.community.annoucement.service;

import java.util.List;

import com.eagle.community.annoucement.entity.Annoucement;
import com.eagle.community.annoucement.entity.Pagination;

/*
 * 通知公告的service接口
 * 
 * */
public interface AnnoucementService {

	/*CRUD基础操作*/
	
	//增加一条通知公告信息
	public Annoucement addAnnoucement(Annoucement an);
	
	//根据id查询一条具体的通知公告信息
	public Annoucement getAnnoucement(long id);
	
	//更新一条已经存在的通知公告信息
	public Annoucement updateAnnoucement(Annoucement an);
	
	//根据id删除一条已经存在的通知公告信息
	public boolean deleteAnnoucement(long id);
	
	//带分页的获得一页通知公告信息
	public Pagination getOnePageAC(int currentPage,int pageSize,boolean desc);
	
	//获得指定的条数的通知公告信息
	public List<Annoucement> getAnnoucements(int size);

	//获取所有的通知公告信息
	public List<Annoucement> getAll();
	
	//获得通知公告的条数
	public int getTotalCount();
	
}
