package com.eagle.community.security;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.eagle.community.admin.controller.HomeController;
import com.eagle.community.admin.entity.Admin;
import com.eagle.community.admin.service.AdminService;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Resource
	private AdminService adminService;

	@Resource
	private UserService userService;

	private static final Logger logger = LogManager.getLogger(MyRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		logger.info("authrizzation invoked !!!!!!!");
		String userName = (String) principalCollection.fromRealm(getName())
				.iterator().next();
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		if (userName.length() > 10) {// 普通居民用户
			User user = userService.findUserById(userName);
			if (user != null) {// 为居民用户赋予user角色
				Set<String> roles = new HashSet<String>();
				roles.add("user");
				simpleAuthorInfo.setRoles(roles);// 为user赋予角色
				Set<String> permissions = new HashSet<String>();
				permissions.add("query");
				simpleAuthorInfo.setStringPermissions(permissions);// 为user赋予权限
				return simpleAuthorInfo;
			} else {
				throw new AuthorizationException();
			}
		} else {// 管理员用户
			Admin admin = adminService.getByUserName(userName);
			if (admin != null) {
				Set<String> roles = new HashSet<String>();
				roles.add(admin.getRole());
				simpleAuthorInfo.setRoles(roles);// 为admin添加角色
				Set<String> permissions = new HashSet<String>();
//				permissions.add("all");
				simpleAuthorInfo.setStringPermissions(permissions);// 为admin用户赋予权限
				return simpleAuthorInfo;
			} else {
				throw new AuthorizationException();
			}
		}
	}

	// 针对两种系统用户的统一登陆验证方法 User -- 普通社区居民 Admin --后台信息的系统管理员用户
	// 判别原则 User的用户民为了方便老年人使用采用身份证后n位，Admin则采用协定的用户名
	// 判别 User userName length>admin userName (限定不能超过10位)
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		logger.info("authentication invoked !!!!!!!");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		AuthenticationInfo authcInfo = null;// 验证信息
		if (token.getUsername().length() > 10) {// 普通居民用户
			User user = userService.authenticate(token.getUsername(),
					new String(token.getPassword()));
			if (user == null) {
				throw new AuthenticationException();
			} else {
				authcInfo = new SimpleAuthenticationInfo(user.getId(),
						user.getPassword(), getName());
				this.setSession("currentUser", user);
				return authcInfo;
			}
		} else {// 管理员用户
			Admin admin = adminService.authenticate(token.getUsername(),
					new String(token.getPassword()));

			if (admin == null) {
				throw new AuthenticationException();// 验证错误直接抛出异常
			} else {
				authcInfo = new SimpleAuthenticationInfo(admin.getUserName(),
						admin.getPassword(), getName());
				this.setSession("currentAdmin", admin);
				return authcInfo;
			}
		}

	}

	/**
	 * ShiroSession设置
	 * 
	 * @see 使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
