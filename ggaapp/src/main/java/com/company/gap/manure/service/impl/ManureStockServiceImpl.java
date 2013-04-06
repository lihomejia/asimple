package com.company.gap.manure.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.BaseDto;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureStockDao;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.service.IManureStockService;
import com.company.gap.manure.tab.TInStock;
import com.company.gap.manure.tab.TOutStock;
import com.company.gap.manure.tab.TStock;

@Service
public class ManureStockServiceImpl implements IManureStockService {

	@Autowired
	private IManureStockDao stockDao;
	
	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	public Dto findStockById(int stock_id) {
		return stockDao.findStockById(stock_id);
	}
	
	@Override
	public Dto selectByStockInfo(Dto stock) {
		return stockDao.selectByStockInfo(stock);
	}
	
	@Override
	public List<Dto> queryAllStock() {
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		List<Dto> stocks = stockDao.queryAllStock();
		for (Dto stock : stocks) {
			stock.put("stock_nameid__disp", resId2Name.get(stock.getInt(TStock.NAMEID)));
			stock.put("stock_sizeid__disp", resId2Name.get(stock.getInt(TStock.SIZEID)));
			stock.put("stock_batchid__disp", resId2Name.get(stock.getInt(TStock.BATCHID)));
			stock.put("stock_producerid__disp", resId2Name.get(stock.getInt(TStock.PRODUCERID)));
		}
		return stocks;
	}
	
	@Override
	public int inAuditing(Dto inStock) {
		//将入库对象转为库存对象.
		Dto stock = new BaseDto();
		stock.put(TStock.NAMEID, inStock.getInt(TInStock.NAMEID));
		stock.put(TStock.SIZEID, inStock.getInt(TInStock.SIZEID));
		stock.put(TStock.BATCHID, inStock.getInt(TInStock.BATCHID));
		stock.put(TStock.PRODUCERID, inStock.getInt(TInStock.PRODUCERID));
		stock.put(TStock.QUANTITY, inStock.getDouble(TInStock.QUANTITY));
		//检索数据库中是否存在该库存对象.
		Dto findStock = this.selectByStockInfo(stock);
		
		int stock_id = 0;
		if (findStock == null) {
			//不存在时，新增并返回库存ID
			stock_id = stockDao.insertStock(stock);
		}
		else {
			//存在时， 从检索的库存对象中取得库存ID
			stock_id = findStock.getInt(TStock.ID);
			//更新库存数.
			stockDao.addStockQuantity(stock_id, inStock.getDouble(TInStock.QUANTITY));
		}
		return stock_id;
	}

	@Override
	public int outAuditing(Dto outStock) {
		return stockDao.addStockQuantity(outStock.getInt(TOutStock.STOCKID), -outStock.getDouble(TOutStock.QUANTITY));
	}

	@Override
	public int addStockQuantity(int stock_id, double quantity) {
		return stockDao.addStockQuantity(stock_id, quantity);
	}


}
