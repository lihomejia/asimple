package com.company.gap.manure.service;

import com.company.gap.base.util.Dto;

public interface IManureInStockService {
	
	Dto findInStockById(int instock_id);
	
	int save(Dto data);
	
	int delete(int instock_id);
	
	int auditing(int instock_id);
	
	int nullify(int instock_id);
	
	
}
