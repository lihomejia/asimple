package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.Status;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.manure.dao.IInStockDao;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IInStockService;
import com.company.gap.manure.service.IStockService;

@Service
public class InStockServiceImpl extends BaseServiceImpl<InStock> implements IInStockService {
	
	@Autowired
	private IInStockDao<InStock> dao;
	
	@Autowired
	private IStockService stockService;
	
	@Override
	protected IBaseDao<InStock> get() {
		return this.dao;
	}

	@Override
	public int approve(Integer id) {
		InStock inStock = dao.findById(id);
		if (inStock.getStatus() == Status.APPROVED.getStatus()) {
			//已审核，直接返回
			return 0;
		}
		int stockId = stockService.inApprove(inStock);
		
		inStock = new InStock();
		inStock.setId(id);
		inStock.setStockId(stockId);
		inStock.setStatus(Status.APPROVED.getStatus());
		
		return dao.update(inStock);
	}
	
	@Override
	public int nullify(Integer id) {
		InStock inStock = dao.findById(id);
		if (inStock.getStatus() == Status.WAITING.getStatus()) {
			inStock = new InStock();
			inStock.setId(id);
			inStock.setStatus(Status.NULLIFY.getStatus());
			return dao.update(inStock);
		}
		
		int stockId = inStock.getStockId();
		Stock stock = stockService.findById(stockId);
		
		if (inStock.getQuantity() > stock.getQuantity()) {
			//数量不够
			return 0;
		}
		stockService.addStockQuantity(stockId, -inStock.getQuantity());
		
		inStock = new InStock();
		inStock.setId(id);
		inStock.setStatus(Status.NULLIFY.getStatus());
		return dao.update(inStock);
	}

}
