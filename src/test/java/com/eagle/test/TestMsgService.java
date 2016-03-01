package com.eagle.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.message.entity.Message;
import com.eagle.community.message.entity.Pagination;
import com.eagle.community.message.service.MessageService;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestMsgService {

	@Resource
	private MessageService messageService;

	@Resource
	private UserService userService;

	// @Test
	public void testGetBySize() {
		List<Message> msgs = messageService.getMSGS(3);
		Iterator<Message> it = msgs.iterator();
		while (it.hasNext()) {
			System.err.println(it.next().toString());
		}
	}

	// @Test
	public void testSaveMessage() {
		User user = userService.findUserById("199405162992");
		Message msg = new Message();
		msg.setContent("班得瑞（Bandari）是瑞士音乐公司A"
				+ "udio Video Communications AG（简称AV"
				+ "C）旗下的一个音乐项目，其作品以环境音乐为主，亦有一些改编自欧美乡村音乐的乐曲"
				+ "，另外还有相当数量的是重新演奏一些成名曲目");
		msg.setDate(new Date(System.currentTimeMillis()));
		msg.setUser(user);

		System.out.println(messageService.addMessage(msg));
	}

	// @Test
	public void testCountMsg() {
		System.err.println(messageService.countAllMsg());
		User user = userService.findUserById("199405162992");
		System.out.println("用户的留言为" + messageService.countUserMsg(user));
	}

	// @Test
	public void testGetAll() {
		List<Message> msgs = messageService.getMsgsByUserId("199405162992");
		Iterator<Message> it = msgs.iterator();
		while (it.hasNext()) {
			System.err.println(it.next().toString());
		}
	}

	// @Test
	public void testPage() {
		Pagination pagination = messageService.getMsgs(0, 2, true);
		Iterator<Message> it = pagination.getMsgs().iterator();
		while (it.hasNext()) {
			System.err.println(it.next().toString());
		}
	}

	@Test
	public void testUserPage() {
		Pagination pagination = messageService.getMsgs(
				userService.findUserById("199405162992"), 0, 3, true);
		Iterator<Message> it = pagination.getMsgs().iterator();
		while (it.hasNext()) {
			System.err.println(it.next().toString());
		}
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
