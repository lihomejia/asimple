package com.company.gap.base.service;

import java.util.Date;
import java.util.List;

public interface IBaseService<T> {
	int save(T t);
	
	int update(T t);
	
	int updateStatus(Integer id, Integer status);
	
	int updateStatus(Integer id, Integer status, Integer cuserId, Date cdate);
	
	int deleteById(Integer id);
	
	int approve(Integer id);
	
	int nullify(Integer id);
	
	List<T> findList();
	
	List<T> findList(T t);

	List<T> findList(String sql, Object... args);
	
	T findById(Integer id);
	
	T findBean(T t);
	
	T findBean(String sql, Object... args);
	
}
