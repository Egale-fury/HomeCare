package com.eagle.community.message.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.message.dao.MessageDao;
import com.eagle.community.message.entity.Message;
import com.eagle.community.message.entity.Pagination;
import com.eagle.community.message.exception.DuplicateMessageException;
import com.eagle.community.message.exception.NoMsgException;
import com.eagle.community.service.BaseService;
import com.eagle.community.user.entity.User;

@Service("messageService")
@Transactional
public class MessageServiceImpl extends BaseService implements MessageService {

	@Resource
	private MessageDao messageDao;

	private static final Logger logger = LogManager
			.getLogger(MessageServiceImpl.class);

	@Override
	public List<Message> getMSGS(int size) {
		List<Message> msgs = messageDao.getMSGS(size);
		if (msgs.size() == 0) {// 还未曾有人留过言
			throw new NoMsgException();
		} else {
			return msgs;
		}
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Message addMessage(Message msg) {
		logger.info("validate message");
		validate(msg);
		Message temp = messageDao.find(msg.getId());
		if (temp != null) {
			logger.info("警告 ：尝试创建一个已经存在的留言");
			throw new DuplicateMessageException();
		} else {
			logger.info("preapare to create a new message ");
			long id = messageDao.save(msg);
			return messageDao.find(id);
		}
	}

	@Override
	public int countAllMsg() {
		return messageDao.getTotalCount();
	}

	@Override
	public int countUserMsg(User user) {

		return messageDao.coutUserMsg(user);
	}

	@Override
	public List<Message> getMsgsByUserId(String userId) {
		return messageDao.getALlMsg(userId);
	}

	@Override
	public Pagination getMsgs(int currentPage, int pageSize, boolean desc) {
		int totalCount = countAllMsg();
		Pagination pagination = new Pagination(currentPage, pageSize,
				totalCount);
		List<Message> list = messageDao.list(currentPage, pageSize, desc);
		if (list.size() == 0) {
			logger.info("暂时还没有留言");
			throw new NoMsgException();
		} else {
			if (totalCount % pageSize == 0) {
				pagination.setTotalPages(totalCount / pageSize);
			} else {
				pagination.setTotalPages(totalCount / pageSize + 1);
			}
			pagination.setMsgs(list);
			return pagination;

		}
	}

	@Override
	public Pagination getMsgs(User user, int currentPage, int pageSize,
			boolean desc) {// 借助SQLQUERY实现
		int totalCount = countUserMsg(user);
		Pagination pagination = new Pagination(currentPage, pageSize,
				totalCount);
		List<Message> list = messageDao.getUserMsg(user.getId(), currentPage,
				pageSize, totalCount / pageSize, desc);
		if (list.size() == 0) {
			logger.info("暂时还没有留言");
			throw new NoMsgException();
		} else {
			if (totalCount % pageSize == 0) {
				pagination.setTotalPages(totalCount / pageSize);
			} else {
				pagination.setTotalPages(totalCount / pageSize + 1);
			}
			pagination.setMsgs(list);
			return pagination;

		}
	}
}
