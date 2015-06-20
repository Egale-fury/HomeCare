package com.eagle.community.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eagle.community.admin.entity.Admin;
import com.eagle.community.admin.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("admin")
public class HomeController {

	@Resource(name = "adminService")
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestBody Admin admin) {
		Admin temp = adminService.authenticate(admin.getUserName(),
				admin.getPassword());
		ModelAndView view = new ModelAndView("/admin/main");// 默认的管理员操作主界面在views/admin目录下
		view.addObject("admin", temp);
		return view;
	}

	
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
