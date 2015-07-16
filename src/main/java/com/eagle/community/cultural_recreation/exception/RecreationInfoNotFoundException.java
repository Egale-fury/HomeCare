package com.eagle.community.cultural_recreation.exception;

import com.eagle.community.exception.BaseWebApplicationException;

/*文化娱乐类信息不存在异常*/
public class RecreationInfoNotFoundException extends
		BaseWebApplicationException {

	public RecreationInfoNotFoundException() {
		super(404, "该条文化类娱乐信息不存在", "试图操作一条不存在的文化娱乐类信息");
	}

}
