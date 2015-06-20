package com.eagle.community.admin.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class AdminNotFoundException extends BaseWebApplicationException{

	public AdminNotFoundException() {
		super(404, "管理员不存在", "试图获取一个不存在的管理员");
		// TODO Auto-generated constructor stub
	}

}
