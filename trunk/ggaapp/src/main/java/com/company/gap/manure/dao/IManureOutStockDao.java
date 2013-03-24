package com.company.gap.manure.dao;

import com.company.gap.manure.entity.ManureOutStock;

public interface IManureOutStockDao {
	ManureOutStock findInStockById(int outstock_id);
	
	int insert(ManureOutStock outStock);
	
	int update(ManureOutStock outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
