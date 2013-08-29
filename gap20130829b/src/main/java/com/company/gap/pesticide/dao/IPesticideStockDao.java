package com.company.gap.pesticide.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public interface IPesticideStockDao<T> extends IBaseDao<T> {
	List<T> findStockList();
	
	int addStockQuantity(Integer id, double quantity);
}
