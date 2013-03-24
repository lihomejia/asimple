package com.company.gap.manure.service;

import com.company.gap.manure.entity.ManureOutStock;

public interface IManureOutStockService {
	ManureOutStock findOutStockById(int outstock_id);
	
	int save(ManureOutStock outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
