package com.eagle.community.admin.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class AuthenticationException extends BaseWebApplicationException{

	public AuthenticationException() {
		super(404, "用户名或密码输入错误", "这个管理员不存在");
		// TODO Auto-generated constructor stub
	}

}
