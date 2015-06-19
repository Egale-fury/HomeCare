package com.eagle.community.news.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NewsNotFoundException extends BaseWebApplicationException{

	public NewsNotFoundException() {
		super(404, "社区动态不存在", "试图去获取一条不存在的社区动态消息");
		// TODO Auto-generated constructor stub
	}



}
