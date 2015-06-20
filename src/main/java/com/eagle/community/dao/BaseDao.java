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
	
	public List<T> list(boolean desc);
	
	public List<T> list(int pageIndex, int pageSize);
	
	public List<T> list(int pageIndex, int pageSize, boolean desc);
	
	public void update(T entity);
	
	public int getTotalCount();
	
}
