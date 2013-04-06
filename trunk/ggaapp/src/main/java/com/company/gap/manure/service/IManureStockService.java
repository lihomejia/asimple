package com.company.gap.manure.service;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IManureStockService {
	
	Dto findStockById(int stock_id);
	
	Dto selectByStockInfo(Dto stock);
	
	List<Dto> queryAllStock();

	int inAuditing(Dto inStock);
	
	int outAuditing(Dto outStock);
	
	int addStockQuantity(int stock_id, double quantity);
}
