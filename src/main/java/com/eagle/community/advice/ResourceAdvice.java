package com.eagle.community.advice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;


//专门来处理在@RequestMapping注释过的方法中出现的异常
@ControllerAdvice(annotations=Controller.class)
public class ResourceAdvice {


	
	
}
