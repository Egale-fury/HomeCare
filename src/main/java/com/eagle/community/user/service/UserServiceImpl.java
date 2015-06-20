package com.eagle.community.user.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.eagle.community.admin.service.AdminServiceImpl;
import com.eagle.community.user.dao.UserDao;
import com.eagle.community.user.entity.User;
import com.eagle.community.user.exception.AuthenticationException;
import com.eagle.community.user.exception.UserNotFoundException;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager
			.getLogger(AdminServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public com.eagle.community.user.entity.User authenticate(String id,
			String password) {
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
		User temp = userDao.find(user.getId());
		if (temp == null) {
			logger.info("要更新的用户不存在!! ");
			throw new UserNotFoundException();
		} else {
			userDao.update(user);
			return user;
		}
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
			logger.info("用户子女信息为 :"+user.getChildren());
			return user;
		}
	}

	@Override
	public User createUser(User user) {
		String id =userDao.save(user);
		return userDao.find(id);
	}

}
