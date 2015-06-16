package com.eagle.community.dao;

import java.io.Serializable;
import java.util.List;

/*
 * author dpc
 * 2015.6.16
 * 
 * */
public interface BaseDao<T, ID extends Serializable>  {
	
	public ID save(T entity);
	
	public T find(ID id);
	
	public void delete(T entity);
	
	public List<T> getAll();
	
	public void update(T entity);
	
	public int getTotalCount();
	
}
