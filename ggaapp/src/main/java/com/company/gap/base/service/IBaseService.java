package com.company.gap.base.service;

import java.util.List;

public interface IBaseService<T> {
	
	List<T> findList();
	
	List<T> findList(T t);

	List<T> findList(String sql, Object... args);
	
	T findById(Integer id);
	
	T findBean(T t);
	
	T findBean(String sql, Object... args);
	
	int save(T t);
	
	int deleteById(Integer id);
}
