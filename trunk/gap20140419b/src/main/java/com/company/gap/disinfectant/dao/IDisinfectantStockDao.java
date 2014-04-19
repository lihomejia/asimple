package com.company.gap.disinfectant.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public interface IDisinfectantStockDao<T> extends IBaseDao<T> {
	List<T> findStockList();
	
	int addStockQuantity(Integer id, double quantity);
}
