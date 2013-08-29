package com.company.gap.medicine.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.medicine.model.InStock;
import com.company.gap.medicine.model.Stock;

public interface IMedicineStockService extends IBaseService<Stock> {
	
	int inApprove(InStock inStock);
	
	int addStockQuantity(Integer id, double quantity);
}
