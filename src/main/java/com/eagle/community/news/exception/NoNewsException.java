package com.eagle.community.news.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NoNewsException extends BaseWebApplicationException{

	public NoNewsException( ) {
		super(404, "暂时还没有添加社区动态消息", "数据库为空，等待添加 ");
		// TODO Auto-generated constructor stub
	}

}
