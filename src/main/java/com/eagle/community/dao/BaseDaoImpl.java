package com.eagle.community.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


/*
 * @author dpc
 * @2015.6.16
 * @paream<T,ID>
 * @implementation of BaseDao 
 * abstract class for explicit xxxDaoImpl
 * */
@Transactional
public abstract class BaseDaoImpl<T, ID extends Serializable> implements
		BaseDao<T, ID> {

	private static final Logger logger = LogManager.getLogger(BaseDaoImpl.class);
	
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;


	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] actualTypes = ((ParameterizedType) type)
				.getActualTypeArguments();
		this.clazz = (Class<T>) actualTypes[0];
	}

	public ID save(T entity) {
		return (ID)getSession().save(entity);
	}

	public T find(ID id) {
		return (T) getSession().get(clazz, id);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public List<T> getAll() {
		return getSession().createCriteria(clazz).list();
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public int getTotalCount() {
		int totalCount = ((Long) getSession()
				.createQuery("select count(*) from " + clazz.getSimpleName())
				.list().get(0)).intValue();
		return totalCount;
	}

	protected Session getSession() {
		if (sessionFactory == null)
			logger.error("BaseDaoImpl :: sessionFactory 注入失败");;
		return sessionFactory.getCurrentSession();
	}
	
	
}
