package com.eagle.community.exception;

public class BadRequestException extends BaseWebApplicationException{

	private static final long serialVersionUID = 1L;

	public BadRequestException( ) {
		super(400, "错误的请求", "请求被拒绝");
		// TODO Auto-generated constructor stub
	}
	
	

}
