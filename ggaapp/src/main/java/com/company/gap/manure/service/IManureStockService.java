package com.company.gap.manure.service;

import java.util.List;
import java.util.Map;

import com.company.gap.manure.entity.ManureInStock;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;

public interface IManureStockService {
	
	ManureStock findStockById(int stock_id);
	
	ManureStock selectByStockInfo(ManureStock stock);
	
	List<Map<String, Object>> queryAllStock();

	int inAuditing(ManureInStock inStock);
	
	int outAuditing(ManureOutStock outStock);
}
