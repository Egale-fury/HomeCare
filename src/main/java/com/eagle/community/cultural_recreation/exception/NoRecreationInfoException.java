package com.eagle.community.cultural_recreation.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NoRecreationInfoException extends BaseWebApplicationException{

	public NoRecreationInfoException() {
		super(404, "暂时未有文化娱乐类信息", "库为空");
	}

}
