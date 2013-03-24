package com.company.gap.pesticide.service;

import com.company.gap.pesticide.entity.PesticideInStock;

public interface IPesticideInStockService {
	
	PesticideInStock findInStockById(int instock_id);
	
	int save(PesticideInStock inStock);
	
	int delete(int instock_id);
	
	int auditing(int instock_id);
	
	int nullify(int instock_id);
	
	
}
