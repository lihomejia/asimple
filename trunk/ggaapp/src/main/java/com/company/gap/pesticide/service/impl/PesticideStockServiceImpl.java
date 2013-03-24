package com.company.gap.pesticide.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.pesticide.dao.IPesticideStockDao;
import com.company.gap.pesticide.entity.PesticideInStock;
import com.company.gap.pesticide.entity.PesticideOutStock;
import com.company.gap.pesticide.entity.PesticideStock;
import com.company.gap.pesticide.service.IPesticideResourceService;
import com.company.gap.pesticide.service.IPesticideStockService;

@Service
public class PesticideStockServiceImpl implements IPesticideStockService {

	@Autowired
	private IPesticideStockDao stockDao;
	
	@Autowired
	private IPesticideResourceService resourceService;
	
	@Override
	public PesticideStock findStockById(int stock_id) {
		return stockDao.findStockById(stock_id);
	}
	
	@Override
	public PesticideStock selectByStockInfo(PesticideStock stock) {
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
	public int inAuditing(PesticideInStock inStock) {
		//将入库对象转为库存对象.
		PesticideStock stock = inStock.getStock();
		//检索数据库中是否存在该库存对象.
		PesticideStock findStock = this.selectByStockInfo(stock);
		
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
	public int outAuditing(PesticideOutStock outStock) {
		return stockDao.addStockQuantity(outStock.getOutstock_stockid(), -outStock.getOutstock_quantity());
	}

	@Override
	public int addStockQuantity(int stock_id, double quantity) {
		return stockDao.addStockQuantity(stock_id, quantity);
	}


}
