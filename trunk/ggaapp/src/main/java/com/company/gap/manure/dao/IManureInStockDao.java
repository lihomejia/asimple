package com.company.gap.manure.dao;

import com.company.gap.manure.entity.ManureInStock;

public interface IManureInStockDao {
	
	ManureInStock findInStockById(int instock_id);
	
	int insert(ManureInStock inStock);
	
	int update(ManureInStock inStock);
	
	int delete(int instock_id);
	
	int auditing(int instock_id, int stock_id);
	
	int nullify(int instock_id);
}
