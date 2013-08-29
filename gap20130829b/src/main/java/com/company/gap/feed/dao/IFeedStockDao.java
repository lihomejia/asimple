package com.company.gap.feed.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public interface IFeedStockDao<T> extends IBaseDao<T> {
	List<T> findStockList();
	
	int addStockQuantity(Integer id, double quantity);
}
