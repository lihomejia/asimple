package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureInStockDao;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureStockService;
import com.company.gap.manure.tab.TInStock;
import com.company.gap.manure.tab.TStock;

@Service
public class ManureInStockServiceImpl implements IManureInStockService {
	
	@Autowired
	private IManureInStockDao inStockDao;
	
	@Autowired
	private IManureStockService stockService;
	
	@Override
	public Dto findInStockById(int instock_id) {
		return inStockDao.findInStockById(instock_id);
	}
	
	
	@Override
	public int save(Dto data) {
		int ret = 0;
		if (data.getInt(TInStock.ID) == 0) {
			ret = inStockDao.insert(data);
		}
		else {
			ret = inStockDao.update(data);
		}
		return ret;
	}


	@Override
	public int delete(int instock_id) {
		return inStockDao.delete(instock_id);
	}
	

	@Override
	public int auditing(int instock_id) {
		Dto inStock = this.findInStockById(instock_id);
		if (inStock.getInt(TInStock.STATUS) == 1) {
			//已审核，直接返回
			return 0;
		}
		int stock_id = stockService.inAuditing(inStock);
		inStockDao.auditing(instock_id, stock_id);
		
		return 0;
	}
	
	@Override
	public int nullify(int instock_id) {
		Dto inStock = this.findInStockById(instock_id);
		if (inStock.getInt(TInStock.STATUS) != 1) {
			//只处理已审核的
			return 0;
		}
		int stock_id = inStock.getInt(TInStock.STOCKID);
		Dto stock = stockService.findStockById(stock_id);
		
		if (inStock.getDouble(TInStock.QUANTITY) > stock.getDouble(TStock.QUANTITY)) {
			//数量不够
			return 0;
		}
		stockService.addStockQuantity(stock_id, -inStock.getDouble(TInStock.QUANTITY));
		return inStockDao.nullify(instock_id);
	}

}
