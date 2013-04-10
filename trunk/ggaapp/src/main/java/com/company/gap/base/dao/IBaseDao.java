package com.company.gap.base.dao;

public interface IBaseDao<T> {

	int insert(T t);
	
	int update(T t);
}
