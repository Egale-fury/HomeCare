package com.eagle.community.user.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NoUserException extends BaseWebApplicationException{

	public NoUserException() {
		super(401, "系统还未录入居民信息", "数据库居民用户信息为空");
		// TODO Auto-generated constructor stub
	}

}
