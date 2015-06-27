package com.eagle.community.health_tip.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class DuplicateHealthTipException extends BaseWebApplicationException{

	public DuplicateHealthTipException() {
		super(409, "该健康贴士已存在", "试图创建一个已经存在的健康贴士");
		// TODO Auto-generated constructor stub
	}

}
