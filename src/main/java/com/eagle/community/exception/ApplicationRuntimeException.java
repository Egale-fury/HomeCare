package com.eagle.community.exception;

public class ApplicationRuntimeException extends BaseWebApplicationException{

	private static final long serialVersionUID = 7072950617568541852L;

	public ApplicationRuntimeException(String developerMessage) {
		super(500, "Internal System error", developerMessage);
	}

}
