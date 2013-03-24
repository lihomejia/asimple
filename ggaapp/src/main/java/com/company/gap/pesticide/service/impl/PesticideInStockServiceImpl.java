package com.company.gap.pesticide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.pesticide.dao.IPesticideInStockDao;
import com.company.gap.pesticide.entity.PesticideInStock;
import com.company.gap.pesticide.entity.PesticideStock;
import com.company.gap.pesticide.service.IPesticideInStockService;
import com.company.gap.pesticide.service.IPesticideStockService;

@Service
public class PesticideInStockServiceImpl implements IPesticideInStockService {
	
	@Autowired
	private IPesticideInStockDao inStockDao;
	
	@Autowired
	private IPesticideStockService stockService;
	
	@Override
	public PesticideInStock findInStockById(int instock_id) {
		return inStockDao.findInStockById(instock_id);
	}
	
	
	@Override
	public int save(PesticideInStock inStock) {
		return inStock.getInstock_id() == 0 ? inStockDao.insert(inStock) : inStockDao.update(inStock);
	}


	@Override
	public int delete(int instock_id) {
		return inStockDao.delete(instock_id);
	}
	

	@Override
	public int auditing(int instock_id) {
		PesticideInStock inStock = this.findInStockById(instock_id);
		if (inStock.getInstock_status() == 1) {
			//已审核，直接返回
			return 0;
		}
		int stock_id = stockService.inAuditing(inStock);
		inStockDao.auditing(instock_id, stock_id);
		
		return 0;
	}
	
	@Override
	public int nullify(int instock_id) {
		PesticideInStock inStock = this.findInStockById(instock_id);
		if (inStock.getInstock_status() != 1) {
			//只处理已审核的
			return 0;
		}
		int stock_id = inStock.getInstock_stockid();
		PesticideStock stock = stockService.findStockById(stock_id);
		
		if (inStock.getInstock_quantity() > stock.getStock_quantity()) {
			//数量不够
			return 0;
		}
		stockService.addStockQuantity(stock_id, -inStock.getInstock_quantity());
		return inStockDao.nullify(instock_id);
	}

}
