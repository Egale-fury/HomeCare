package com.eagle.community.admin.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eagle.community.admin.entity.Admin;
import com.eagle.community.admin.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("admin")
public class HomeController {

	@Resource(name = "adminService")
	private AdminService adminService;

	private static final Logger logger = LogManager
			.getLogger(HomeController.class);

	// 开始登陆的跳转
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "admin/backlogin";// 接受请求后跳转到后台的登陆页面
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password,
			HttpServletRequest request, HttpSession session) {
		logger.info("/login is invoked");

		UsernamePasswordToken token = new UsernamePasswordToken(userName,
				password);// 配置用户名/密码口令
		try {
			SecurityUtils.getSubject().login(token);// 执行用户验证

		} catch (AuthenticationException e) {
			logger.info("管理员用户民或密码错误");
			return "admin/backlogin"; // 注意：
		}
		return "admin/common/backmanage";
	}

	@RequiresAuthentication
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		// 更新管理员 lastLoginDate属性"
		Admin admin = (Admin) session.getAttribute("currentAdmin");
		admin.setLastLoginDate(new Date(System.currentTimeMillis()));
		String ip = getRemoteHost(request);
		admin.setLastLoginIP(ip);
		// 调用adminService对管理员信息进行持久化,但是不操作session中的currentAdmin对象
		adminService.updateAdminInfo(admin);

		// 调用subject执行注销
		SecurityUtils.getSubject().logout();
		return "admin/backlogin";
	}

	// 获取请求的客户端的真是ip地址（使用了代理也能获得）
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
