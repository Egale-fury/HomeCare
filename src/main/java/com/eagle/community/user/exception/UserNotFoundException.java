package com.eagle.community.user.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class UserNotFoundException extends BaseWebApplicationException {

	public UserNotFoundException( ) {
		super(404, "用户不存在", "试图操作一个不存在的用户 !");
		// TODO Auto-generated constructor stub
	}

	
}
