package com.company.gap.pesticide.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.pesticide.entity.PesticideStock;

public interface IPesticideStockDao {
	PesticideStock findStockById(int stock_id);
	
	PesticideStock selectByStockInfo(PesticideStock stock);
	
	List<Map<String, Object>> queryAllStock();
	
	int insertStock(PesticideStock stock);
	
	int addStockQuantity(int stock_id, double quantity);
}
