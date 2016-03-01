package com.eagle.community.message.controller;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eagle.community.message.service.MessageService;

//留言的controller
@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Resource
	private MessageService messageService;

	private static final Logger logger = LogManager
			.getLogger(MessageController.class);

	
	
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	
}
