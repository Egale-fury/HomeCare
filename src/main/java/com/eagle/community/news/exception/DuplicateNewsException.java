package com.eagle.community.news.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class DuplicateNewsException extends BaseWebApplicationException{

	public DuplicateNewsException() {
		super(401, "CommunityNews already exists", "试图去创建一条已经存在的社区动态消息");
	}

}
