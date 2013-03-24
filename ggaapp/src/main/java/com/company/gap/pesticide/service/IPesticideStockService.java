package com.company.gap.pesticide.service;

import java.util.List;
import java.util.Map;

import com.company.gap.pesticide.entity.PesticideInStock;
import com.company.gap.pesticide.entity.PesticideOutStock;
import com.company.gap.pesticide.entity.PesticideStock;

public interface IPesticideStockService {
	
	PesticideStock findStockById(int stock_id);
	
	PesticideStock selectByStockInfo(PesticideStock stock);
	
	List<Map<String, Object>> queryAllStock();

	int inAuditing(PesticideInStock inStock);
	
	int outAuditing(PesticideOutStock outStock);
	
	int addStockQuantity(int stock_id, double quantity);
}
