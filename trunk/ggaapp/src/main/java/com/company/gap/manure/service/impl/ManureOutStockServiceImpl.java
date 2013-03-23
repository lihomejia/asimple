package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.manure.dao.IManureOutStockDao;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;

@Service
public class ManureOutStockServiceImpl implements IManureOutStockService {

	@Autowired
	private IManureOutStockDao outStockDao;
	@Autowired
	private IManureStockService stockService;
	
	@Override
	public ManureOutStock findOutStockById(int outstock_id) {
		return outStockDao.findInStockById(outstock_id);
	}

	@Override
	public int save(ManureOutStock outStock) {
		int stock_id = outStock.getOutstock_stockid();
		ManureStock stock = stockService.findStockById(stock_id);
		
		outStock.setOutstock_nameid(stock.getStock_nameid());
		outStock.setOutstock_sizeid(stock.getStock_sizeid());
		outStock.setOutstock_batchid(stock.getStock_batchid());
		outStock.setOutstock_producerid(stock.getStock_producerid());
		outStock.setOutstock_kindid(stock.getStock_kindid());
		
		return outStock.getOutstock_id() == 0 ? outStockDao.insert(outStock) : outStockDao.update(outStock);
	}
	

	@Override
	public int delete(int outstock_id) {
		return outStockDao.delete(outstock_id);
	}
	
	@Override
	public int auditing(int outstock_id) {
		ManureOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != 0) {
			//已审核，直接返回
			return 0;
		}
		ManureStock stock = stockService.findStockById(outStock.getOutstock_stockid());
		if (stock == null) return 0;
		
		if (outStock.getOutstock_quantity() > stock.getStock_quantity()) {
			return 0;
		}
		
		stockService.outAuditing(outStock);
		outStockDao.auditing(outstock_id);
		
		
		return outStockDao.auditing(outstock_id);
	}

}
