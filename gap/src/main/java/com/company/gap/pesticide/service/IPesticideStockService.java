package com.company.gap.pesticide.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.pesticide.model.InStock;
import com.company.gap.pesticide.model.Stock;

public interface IPesticideStockService extends IBaseService<Stock> {
	
	int inApprove(InStock inStock);
	
	int addStockQuantity(Integer id, double quantity);
	
	List<Stock> findStockList();
}
