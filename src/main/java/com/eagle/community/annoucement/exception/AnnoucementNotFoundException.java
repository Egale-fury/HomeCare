package com.eagle.community.annoucement.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class AnnoucementNotFoundException extends BaseWebApplicationException {

	public AnnoucementNotFoundException() {
		super(404, "该通知公告不存在", "试图操作一个不存在的社区通知公告");
	}

}
