package com.company.gap.manure.dao;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IManureStockDao {
	Dto findStockById(int stock_id);
	
	Dto selectByStockInfo(Dto stock);
	
	List<Dto> queryAllStock();
	
	int insertStock(Dto stock);
	
	int addStockQuantity(int stock_id, double quantity);
}
