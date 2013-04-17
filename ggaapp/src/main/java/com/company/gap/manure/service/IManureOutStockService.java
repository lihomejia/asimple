package com.company.gap.manure.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.model.OutStock;


public interface IManureOutStockService extends IBaseService<OutStock> {
	
	int approve(Integer id);
	
	int nullify(Integer id);
}
