package com.eagle.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.admin.entity.Admin;
import com.eagle.community.admin.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestAdminService {

	@Resource(name = "adminService")
	private AdminService adminService;

	// @Test
	public void testAuthenticate() {
		// System.out.println("正准备创建admin表");
		Admin admin = adminService.authenticate("admin", "123456");
		System.out.println(admin);
	}
	
	@Test
	public void testAdminUpdate(){
		Admin admin =new Admin(1,"admin","654321","172.26.2.129",new Date());
		adminService.updateAdminInfo(admin);
	}

}
