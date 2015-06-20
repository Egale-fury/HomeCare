package com.eagle.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class TestUserService {
	
	@Resource(name="userService")
	private UserService userService;
	
	//@Test
	public void testAuthenticate(){
		User user =userService.authenticate("195101204163", "123456");
		System.out.println(user);
	}
	
	@Test
	public void testUpdateUser(){
//		User user =userService.findUserById("195101204163");
//		user.setEthnicity("满族");
//		userService.updateUser(user);
		
		
		User user =new User();
		user.setId("199405162992");
		user.setEthnicity("皇族");
		user.setAddress("中南海");
		
		userService.createUser(user);
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
