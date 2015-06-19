package com.eagle.community.advice;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eagle.community.api.ErrorResponse;
import com.eagle.community.exception.ApplicationRuntimeException;
import com.eagle.community.exception.BaseWebApplicationException;


//专门来处理在@RequestMapping注释过的方法中出现的异常
@ControllerAdvice(annotations=Controller.class)
public class ResourceAdvice {

	private static final Logger logger = LogManager
			.getLogger(ResourceAdvice.class);
	
	@ExceptionHandler(BaseWebApplicationException.class)
	@ResponseBody
	public ErrorResponse processBaseWebApplicationException(BaseWebApplicationException e) {
		logger.error(e.getDeveloperMessage(),e);
		return e.getErrorResponse();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse processException(Exception e) {
		logger.error(e.getMessage(),e);
		return new ApplicationRuntimeException(e.getMessage()).getErrorResponse();
	}
	
	
}
