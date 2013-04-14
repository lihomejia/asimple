package com.company.gap.manure.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.model.Stock;

public interface IStockService extends IBaseService<Stock> {
	
	int inApprove(InStock inStock);
	
	int addStockQuantity(Integer id, double quantity);
	
	List<Stock> findStockList();
}