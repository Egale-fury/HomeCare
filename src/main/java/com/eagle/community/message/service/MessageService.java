package com.eagle.community.message.service;

import java.util.List;

import com.eagle.community.message.entity.Message;
import com.eagle.community.message.entity.Pagination;
import com.eagle.community.user.entity.User;


//留言信息处理服务接口
public interface MessageService {

	//一次获得指定条数的留言信息(默认按时间的先后顺序)
	public List<Message> getMSGS(int size);
	
	
	//增加一条留言
	public Message addMessage(Message msg);
	
	//根据用户的id查找用户的所有留言
	public List<Message> getMsgsByUserId(String userId);
	
	//分页获取一定数目的留言信息
	public Pagination getMsgs(int currentPage, int pageSize ,boolean desc);
	
	//分页获取某个用户的留言信息
	public Pagination getMsgs(User user ,int currentPage, int pageSize, boolean desc);
	
	//获得所有的留言数目
	public int countAllMsg();
	
	//获得某个用户的所有留言条数
	public int countUserMsg(User user);
	
	
}
