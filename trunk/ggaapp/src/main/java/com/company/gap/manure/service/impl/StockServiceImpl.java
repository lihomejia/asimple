package com.company.gap.manure.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IStockDao;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IResourceService;
import com.company.gap.manure.service.IStockService;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock> implements IStockService {

	@Autowired
	private IStockDao<Stock> dao;
	
	@Autowired
	private IResourceService resourceService;

	@Override
	protected IBaseDao<Stock> get() {
		return this.dao;
	}
	
	@Override
	public int inApprove(InStock inStock) {
		Stock stock = new Stock();
		stock.setNameId(inStock.getNameId());
		stock.setSpecId(inStock.getSpecId());
		stock.setBatchId(inStock.getBatchId());
		stock.setProducerId(inStock.getProducerId());
		//检索数据库中是否存在该库存对象.
		Stock findStock = this.findBean(stock);
		
		int id = 0;
		if (findStock == null) {
			//不存在时，新增并返回库存ID
			id = dao.insert2(stock);
		}
		else {
			//存在时， 从检索的库存对象中取得库存ID
			id = findStock.getId();
			//更新库存数.
			this.addStockQuantity(id, inStock.getQuantity());
		}
		return id;
	}

	@Override
	public int addStockQuantity(Integer id, double quantity) {
		return dao.addStockQuantity(id, quantity);
	}
	
	@Override
	public List<Stock> findStockList() {
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		List<Stock> list = dao.findStockList();
		for (Stock stock : list) {
			Dto __added = stock.get__added();
			__added.put("nameId", resId2Name.get(stock.getNameId()));
			__added.put("specId", resId2Name.get(stock.getSpecId()));
			__added.put("batchId", resId2Name.get(stock.getBatchId()));
			__added.put("producerId", resId2Name.get(stock.getProducerId()));
		}
		return list;
	}
}