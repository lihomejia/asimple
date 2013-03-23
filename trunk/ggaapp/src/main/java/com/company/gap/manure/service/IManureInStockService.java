package com.company.gap.manure.service;

import com.company.gap.manure.entity.ManureInStock;

public interface IManureInStockService {
	
	ManureInStock findInStockById(int instock_id);
	
	int save(ManureInStock inStock);
	
	int delete(int instock_id);
	
	int auditing(int instock_id);
	
	
}
