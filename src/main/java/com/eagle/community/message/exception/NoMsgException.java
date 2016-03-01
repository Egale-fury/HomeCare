package com.eagle.community.message.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NoMsgException extends BaseWebApplicationException{

	public NoMsgException( ) {
		super(404, "还未有人留过言", "数据库为空，等待留言 ");
		// TODO Auto-generated constructor stub
	}
}
