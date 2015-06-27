package com.eagle.community.health_tip.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class HealthTipNotFoudException extends BaseWebApplicationException{

	public HealthTipNotFoudException() {
		super(404, "健康贴士不存在", "试图操作一个不存在的健康小贴士");
		// TODO Auto-generated constructor stub
	}

}
