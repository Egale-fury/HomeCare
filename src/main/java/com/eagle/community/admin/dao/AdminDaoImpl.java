package com.eagle.community.admin.dao;

import java.awt.image.RescaleOp;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.admin.entity.Admin;
import com.eagle.community.dao.BaseDaoImpl;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl extends BaseDaoImpl<Admin, Integer> implements AdminDao{

	//通过用户名和密码验证
	@Override
	public Admin authenticate(String userName, String password) {
		Criteria criteria=createCriteria();
		Admin admin =(Admin)criteria.add(Restrictions.eq("userName", userName))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
		return admin;
	}

	@Override
	public Admin getByUserName(String userName) {
		Criteria criteria =createCriteria();
		Admin admin=(Admin)criteria.add(Restrictions.eq("userName", userName)).uniqueResult();
		return admin;
	}
	

}
