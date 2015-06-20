package com.eagle.community.user.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.user.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	@Override
	public User authenticate(String id, String password) {
		Criteria criteria = createCriteria();
		User user =(User)criteria.add(Restrictions.eq("id", id)).add(
				Restrictions.eq("password", password))
				.uniqueResult();
		return user;
	}
	
	

}
