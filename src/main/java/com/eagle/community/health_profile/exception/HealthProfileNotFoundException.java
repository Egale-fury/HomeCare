package com.eagle.community.health_profile.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class HealthProfileNotFoundException extends BaseWebApplicationException{

	public HealthProfileNotFoundException() {
		super(404, "用户健康档案尚未创建", "试图获取一份不存在的健康档案");
		// TODO Auto-generated constructor stub
	}
	
}
