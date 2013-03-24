package com.company.gap.manure.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.manure.dao.IManureStockDao;
import com.company.gap.manure.entity.ManureInStock;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.service.IManureStockService;

@Service
public class ManureStockServiceImpl implements IManureStockService {

	@Autowired
	private IManureStockDao stockDao;
	
	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	public ManureStock findStockById(int stock_id) {
		return stockDao.findStockById(stock_id);
	}
	
	@Override
	public ManureStock selectByStockInfo(ManureStock stock) {
		return stockDao.selectByStockInfo(stock);
	}
	
	@Override
	public List<Map<String, Object>> queryAllStock() {
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		List<Map<String, Object>> stocks = stockDao.queryAllStock();
		for (Map<String, Object> stock : stocks) {
			stock.put("stock_nameid__disp", resId2Name.get((Integer) stock.get("stock_nameid")));
			stock.put("stock_sizeid__disp", resId2Name.get((Integer) stock.get("stock_sizeid")));
			stock.put("stock_batchid__disp", resId2Name.get((Integer) stock.get("stock_batchid")));
			stock.put("stock_producerid__disp", resId2Name.get((Integer) stock.get("stock_producerid")));
		}
		
		return stocks;
	}
	
	@Override
	public int inAuditing(ManureInStock inStock) {
		//将入库对象转为库存对象.
		ManureStock stock = inStock.getStock();
		//检索数据库中是否存在该库存对象.
		ManureStock findStock = this.selectByStockInfo(stock);
		
		int stock_id = 0;
		if (findStock == null) {
			//不存在时，新增并返回库存ID
			stock_id = stockDao.insertStock(stock);
		}
		else {
			//存在时， 从检索的库存对象中取得库存ID
			stock_id = findStock.getStock_id();
			//更新库存数.
			stockDao.addStockQuantity(stock_id, inStock.getInstock_quantity());
		}
		return stock_id;
	}

	@Override
	public int outAuditing(ManureOutStock outStock) {
		return stockDao.addStockQuantity(outStock.getOutstock_stockid(), -outStock.getOutstock_quantity());
	}

	@Override
	public int addStockQuantity(int stock_id, double quantity) {
		return stockDao.addStockQuantity(stock_id, quantity);
	}


}
