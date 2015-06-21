package com.eagle.community.user.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class ChildNotFoundException extends BaseWebApplicationException{

	public ChildNotFoundException() {
		super(404,"用户没有这个子女", "试图操作一个不存在子女信息");
		// TODO Auto-generated constructor stub
	}

	
	
}
