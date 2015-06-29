package com.eagle.community.health_profile.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class DuplicateHealthProfileException extends
		BaseWebApplicationException {

	public DuplicateHealthProfileException() {
		super(401, "用户健康档案已存在", "试图添加一份已经此在的健康档案");
		// TODO Auto-generated constructor stub
	}

}
