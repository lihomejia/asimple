package com.company.gap.manure.dao;

import com.company.gap.base.util.Dto;

public interface IManureOutStockDao {
	Dto findInStockById(int outstock_id);
	
	int insert(Dto outStock);
	
	int update(Dto outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
