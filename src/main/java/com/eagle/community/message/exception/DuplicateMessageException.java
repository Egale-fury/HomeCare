package com.eagle.community.message.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class DuplicateMessageException extends BaseWebApplicationException{

	public DuplicateMessageException() {
		super(401, "留言信息已存在", "试图去创建一条已经存在的留言");
	}
}
