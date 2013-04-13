package com.company.gap.manure.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.model.InStock;


public interface IInStockService extends IBaseService<InStock> {
	
	int approve(Integer id);
	
	int nullify(Integer id);
	
	
}
