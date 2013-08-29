package com.company.gap.manure.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public interface IManureStockDao<T> extends IBaseDao<T> {
	List<T> findStockList();
	
	int addStockQuantity(Integer id, double quantity);
}
