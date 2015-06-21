package com.eagle.community.user.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class DuplicateUserException extends BaseWebApplicationException{

	public DuplicateUserException() {
		super(409, "User already exists", "An attempt was made to create a user that already exists");
		// TODO Auto-generated constructor stub
	}

}
