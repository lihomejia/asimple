package com.company.gap.pesticide.dao;

import com.company.gap.pesticide.entity.PesticideOutStock;

public interface IPesticideOutStockDao {
	PesticideOutStock findInStockById(int outstock_id);
	
	int insert(PesticideOutStock outStock);
	
	int update(PesticideOutStock outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
