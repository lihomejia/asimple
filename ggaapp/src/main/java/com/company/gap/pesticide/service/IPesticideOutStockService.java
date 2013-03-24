package com.company.gap.pesticide.service;

import com.company.gap.pesticide.entity.PesticideOutStock;

public interface IPesticideOutStockService {
	PesticideOutStock findOutStockById(int outstock_id);
	
	int save(PesticideOutStock outStock);
	
	int delete(int outstock_id);
	
	int auditing(int outstock_id);
	
	int nullify(int outstock_id);
}
