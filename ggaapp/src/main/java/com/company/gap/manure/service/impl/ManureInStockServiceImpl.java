package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.manure.dao.IManureInStockDao;
import com.company.gap.manure.entity.ManureInStock;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureStockService;

@Service
public class ManureInStockServiceImpl implements IManureInStockService {
	
	@Autowired
	private IManureInStockDao inStockDao;
	
	@Autowired
	private IManureStockService stockService;
	
	@Override
	public ManureInStock findInStockById(int instock_id) {
		return inStockDao.findInStockById(instock_id);
	}
	
	
	@Override
	public int save(ManureInStock inStock) {
		return inStockDao.insert(inStock);
	}


	@Override
	public int delete(int instock_id) {
		return inStockDao.delete(instock_id);
	}

	

	@Override
	public int auditing(int instock_id) {
		ManureInStock inStock = this.findInStockById(instock_id);
		if (inStock.getInstock_status() != 1) {
			//已审核，直接返回
			return 0;
		}
		int stock_id = stockService.inAuditing(inStock);
		inStockDao.auditing(instock_id, stock_id);
		
		return 0;
	}

}
