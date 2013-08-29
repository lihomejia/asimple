package com.company.gap.medicine.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public interface IMedicineStockDao<T> extends IBaseDao<T> {
	List<T> findStockList();
	
	int addStockQuantity(Integer id, double quantity);
}
