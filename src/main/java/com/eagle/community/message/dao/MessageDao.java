package com.eagle.community.message.dao;

import java.util.List;

import com.eagle.community.dao.BaseDao;
import com.eagle.community.message.entity.Message;
import com.eagle.community.user.entity.User;

//负责留言信息处理的DAO
public interface MessageDao extends BaseDao<Message, Long>{

	//一次性获得指定的条数的留言信息
	public List<Message> getMSGS(int size);
	
	
	//查询某个用户的所有留言信息条数
	public int coutUserMsg(User user);
	
	//根据userID查找用户的所有留言
	public List<Message> getALlMsg(String userId);
	
	//分页返回用户的留言信息
	public List<Message> getUserMsg(String userId,int currentPage, int pageSize,int pageCount, boolean desc);
}
