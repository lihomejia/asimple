package com.company.gap.disinfectant.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.disinfectant.model.InStock;
import com.company.gap.disinfectant.model.Stock;

public interface IDisinfectantStockService extends IBaseService<Stock> {
	
	int inApprove(InStock inStock);
	
	int addStockQuantity(Integer id, double quantity);
}
