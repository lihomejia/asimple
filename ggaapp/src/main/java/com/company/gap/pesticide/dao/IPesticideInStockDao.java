package com.company.gap.pesticide.dao;

import com.company.gap.pesticide.entity.PesticideInStock;

public interface IPesticideInStockDao {
	
	PesticideInStock findInStockById(int instock_id);
	
	int insert(PesticideInStock inStock);
	
	int update(PesticideInStock inStock);
	
	int delete(int instock_id);
	
	int auditing(int instock_id, int stock_id);
	
	int nullify(int instock_id);
}
