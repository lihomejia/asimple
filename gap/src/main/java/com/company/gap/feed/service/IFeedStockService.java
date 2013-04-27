package com.company.gap.feed.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.feed.model.InStock;
import com.company.gap.feed.model.Stock;

public interface IFeedStockService extends IBaseService<Stock> {
	
	int inApprove(InStock inStock);
	
	int addStockQuantity(Integer id, double quantity);
	
	List<Stock> findStockList();
}
