package com.eagle.community.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

/*
 * @author dpc
 * @2015.6.16
 * @paream<T,ID>
 * @implementation of BaseDao 
 * abstract class for explicit xxxDaoImpl
 * */
public abstract class BaseDaoImpl<T, ID extends Serializable> implements
		BaseDao<T, ID> {

	private static final Logger logger = LogManager
			.getLogger(BaseDaoImpl.class);

	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;
	private String pkName;

	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] actualTypes = ((ParameterizedType) type)
				.getActualTypeArguments();
		this.clazz = (Class<T>) actualTypes[0];
		this.pkName = analysePKName(this.clazz, "id");
	}

	private String analysePKName(Class claz, String defaultName) {

		String id = defaultName;
		if (claz.getSuperclass().isAnnotationPresent(MappedSuperclass.class)) {
			claz = claz.getSuperclass();
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Id.class)) {
				if (method.isAnnotationPresent(Column.class)) {
					Column column = method.getAnnotation(Column.class);
					if (column.name().length() > 0) {
						id = column.name();
					}
				}
				return id;
			}
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class)) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.name().length() > 0) {
						id = column.name();

					}
				}
				return id;
			}
		}
		return id;
	}

	protected Criteria orderDesc(Criteria criteria, boolean desc) {
		if (desc) {
			criteria.addOrder(Order.desc(pkName));
		}
		return criteria;
	}

	protected Criteria orderAsc(Criteria criteria, String colName, boolean desc) {
		return orderDesc(criteria, false);
	}

	/**
	 * @param criteria
	 * @param colName
	 * @param desc
	 *            <strong>if the param is true, result order by desc , else
	 *            order by asc
	 * @return
	 */
	protected Criteria orderDesc(Criteria criteria, String colName, boolean desc) {
		criteria.addOrder(desc ? Order.desc(colName) : Order.asc(colName));
		return criteria;
	}

	public Criteria createCriteria() {
		return getSession().createCriteria(clazz);
	}

	public ID save(T entity) {
		return (ID) getSession().save(entity);
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

	public List<T> list(boolean desc) {
		Criteria criteria = getSession().createCriteria(clazz);
		orderDesc(criteria, desc);
		return criteria.list();
	}

	public List<T> list(int pageIndex, int pageSize) {
		return list(pageIndex, pageSize, false);
	}

	public List<T> list(int pageIndex, int pageSize, boolean desc) {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setMaxResults(pageSize);
        criteria.setFirstResult(pageIndex * pageSize);
		orderDesc(criteria, desc);
		return criteria.list();
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
			logger.error("BaseDaoImpl :: sessionFactory 注入失败");
		;
		return sessionFactory.getCurrentSession();
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

}
