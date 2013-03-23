package com.company.gap.manure.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.manure.entity.ManureStock;

public interface IManureStockDao {
	ManureStock findStockById(int stock_id);
	
	ManureStock selectByStockInfo(ManureStock stock);
	
	List<Map<String, Object>> queryAllStock();
	
	int insertStock(ManureStock stock);
	
	int addStockQuantity(int stock_id, double quantity);
}
