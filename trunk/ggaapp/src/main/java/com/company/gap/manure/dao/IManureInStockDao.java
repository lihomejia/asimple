package com.company.gap.manure.dao;

import com.company.gap.base.util.Dto;

public interface IManureInStockDao {
	
	Dto findInStockById(int instock_id);
	
	int insert(Dto data);
	
	int update(Dto data);
	
	int delete(int instock_id);
	
	int auditing(int instock_id, int stock_id);
	
	int nullify(int instock_id);
}
