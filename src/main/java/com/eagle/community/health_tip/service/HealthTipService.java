package com.eagle.community.health_tip.service;

import java.util.List;

import com.eagle.community.health_tip.entity.HealthTip;
import com.eagle.community.health_tip.entity.Pagination;

public interface HealthTipService {

	//增加一条健康小贴士
	public HealthTip addTip(HealthTip tip);
	
	//删除一条健康小贴士
	public boolean deleteTip(HealthTip tip);
	
	//根据id获得一条健康小贴士
	public HealthTip getTip(long id);
	
	//更新一条健康小贴士
	public HealthTip updateTip(HealthTip tip);
	
	//获得健康小贴士的总条数
	public int getTotalCount();
	
	//一次性获得最新的size条健康小贴士
	public List<HealthTip> getTips(int size);
	
	//获得所有的健康小贴士
	public List<HealthTip> getAllTips();
	
	public Pagination getTips(int currentPage,int pageSize,boolean desc);
	
}
