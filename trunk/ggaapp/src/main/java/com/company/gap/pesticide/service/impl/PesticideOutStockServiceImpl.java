package com.company.gap.pesticide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.pesticide.dao.IPesticideOutStockDao;
import com.company.gap.pesticide.entity.PesticideOutStock;
import com.company.gap.pesticide.entity.PesticideStock;
import com.company.gap.pesticide.service.IPesticideOutStockService;
import com.company.gap.pesticide.service.IPesticideStockService;

@Service
public class PesticideOutStockServiceImpl implements IPesticideOutStockService {

	@Autowired
	private IPesticideOutStockDao outStockDao;
	@Autowired
	private IPesticideStockService stockService;
	
	@Override
	public PesticideOutStock findOutStockById(int outstock_id) {
		return outStockDao.findInStockById(outstock_id);
	}

	@Override
	public int save(PesticideOutStock outStock) {
		int stock_id = outStock.getOutstock_stockid();
		PesticideStock stock = stockService.findStockById(stock_id);
		
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
		PesticideOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != 0) {
			//已审核，直接返回
			return 0;
		}
		PesticideStock stock = stockService.findStockById(outStock.getOutstock_stockid());
		if (stock == null) return 0;
		
		if (outStock.getOutstock_quantity() > stock.getStock_quantity()) {
			return 0;
		}
		
		stockService.outAuditing(outStock);
		outStockDao.auditing(outstock_id);
		
		
		return outStockDao.auditing(outstock_id);
	}

	@Override
	public int nullify(int outstock_id) {
		PesticideOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != 1) {
			//只处理已审核的
			return 0;
		}
		int stock_id = outStock.getOutstock_stockid();
		
		stockService.addStockQuantity(stock_id, outStock.getOutstock_quantity());
		return outStockDao.nullify(outstock_id);
	}

}
