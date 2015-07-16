package com.eagle.community.message.entity;

import java.util.Date;
import java.util.Set;

import com.eagle.community.user.entity.User;

/*
 * 留言的实体类
 * 
 */
public class Message {
	
	private long id;
	
	private String content;
	
	private Date date;
	
	private User user;
	
	private Set<Reply> replies;
	
	
	
}
