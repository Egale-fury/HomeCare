package com.eagle.community.user.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.community.admin.service.AdminServiceImpl;
import com.eagle.community.service.BaseService;
import com.eagle.community.user.dao.UserDao;
import com.eagle.community.user.entity.Child;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.exception.AuthenticationException;
import com.eagle.community.user.exception.DuplicateUserException;
import com.eagle.community.user.exception.UserNotFoundException;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	private static final Logger logger = LogManager
			.getLogger(AdminServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public User authenticate(String id, String password) {
		User user = userDao.authenticate(id, password);
		if (user == null) {
			logger.info("用户名或密码不正确");
			throw new AuthenticationException();
		} else {
			return user;
		}
	}

	@Override
	public User updateUser(User user) {
		validate(user);
		userDao.update(user);
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findUserById(String id) {
		User user = userDao.find(id);
		if (user == null) {
			logger.info("id为：" + id + "的用户不存在 !");
			throw new UserNotFoundException();
		} else {
			// logger.info("用户子女信息为 :" + user.getChildren());
			return user;
		}
	}

	@Override
	public User createUser(User user) {
		validate(user);
		if (userDao.find(user.getId()) == null) {
			logger.info("用户尚不存在，准备创建用户");
			userDao.save(user);
			return user;
		} else {
			logger.info("该用户已存在!");
			throw new DuplicateUserException();
		}
	}

	@Override
	public User addChildForUser(String id, Child childs) {
		User user =findUserById(id);
		if(user!=null){
			validate(childs);
			user.getChildren().add(childs);
		}else{
			throw new UserNotFoundException();
		}
		return user;
	}

}
