package com.eagle.community.advice;


import javax.validation.ConstraintViolationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eagle.community.api.ErrorResponse;
import com.eagle.community.exception.ApplicationRuntimeException;
import com.eagle.community.exception.BaseWebApplicationException;
import com.eagle.community.exception.ValidationException;


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
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ErrorResponse processConstraintViolationException(ConstraintViolationException e) {
		logger.error(e.getMessage());
		return new ValidationException(e.getConstraintViolations()).getErrorResponse();
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ErrorResponse processHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		logger.error(e.getMessage());
		return new ValidationException("请求实体格式有误").getErrorResponse();
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse processException(Exception e) {
		logger.error(e.getMessage(),e);
		return new ApplicationRuntimeException(e.getMessage()).getErrorResponse();
	}
	
	@ExceptionHandler(UnauthenticatedException.class)
	public String processUnauthenticatedException(UnauthenticatedException e){
		logger.error(e.getMessage());
		return "/403";
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public String processUnauthorizedException(UnauthorizedException e){
		logger.error(e.getMessage());
		return "/403";
	}
	
	
	//
}
