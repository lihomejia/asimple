package com.company.gap.manure.service;

import com.company.gap.base.util.Dto;

public interface IManureOutStockService {
	Dto findOutStockById(int outstock_id);
	
	int save(Dto outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
