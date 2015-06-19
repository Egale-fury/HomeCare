package com.eagle.community.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eagle.community.api.ErrorResponse;

@Controller
public class ErrorController {
	@RequestMapping(value="/error")
	public ErrorResponse handle(HttpServletRequest request) {
		String status = String.valueOf(request.getAttribute("javax.servlet.error.status_code"));
		String reason = String.valueOf(request.getAttribute("javax.servlet.error.message"));
		return new ErrorResponse(status, reason, reason);
	}
	
}
