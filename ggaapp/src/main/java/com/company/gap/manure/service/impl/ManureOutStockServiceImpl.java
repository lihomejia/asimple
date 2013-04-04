package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.manure.dao.IManureOutStockDao;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.enumeration.ManureOutStockStatus;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;

@Service
public class ManureOutStockServiceImpl implements IManureOutStockService {

	@Autowired
	private IManureOutStockDao outStockDao;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	
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
		
		int ret = 0;
		if (outStock.getOutstock_id() == 0) {
			int registerId = outStock.getOutstock_registerid();
			GrowRegister register = registerService.findGrowRegister(registerId);
			outStock.setOutstock_cellid(register.getRegister_cellid());
			
			ret = outStockDao.insert(outStock);
		} else {
			ret = outStockDao.update(outStock);
		}
		double diff = outStock.getOutstock_quantity() - outStock.getOutstock_oquantity();
		if (diff != 0) {
			stockService.addStockQuantity(stock_id, -diff);
		}
		
		return ret;
	}
	

	@Override
	public int delete(int outstock_id) {
		ManureOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != ManureOutStockStatus.UNAUDITED.getStatus()) {
			//只能删除未审核的
			return 0;
		}
		int stock_id = outStock.getOutstock_stockid();
		//彻底删除，故需要在此将库存加回去.
		stockService.addStockQuantity(stock_id, outStock.getOutstock_quantity());
		return outStockDao.delete(outstock_id);
	}
	
	@Override
	public int auditing(int outstock_id) {
		ManureOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != 0) {
			//已审核，直接返回
			return 0;
		}
		return outStockDao.auditing(outstock_id);
	}

	@Override
	public int nullify(int outstock_id) {
		ManureOutStock outStock = this.findOutStockById(outstock_id);
		if (outStock.getOutstock_status() != 1) {
			//只处理已审核的
			return 0;
		}
		int stock_id = outStock.getOutstock_stockid();
		//对于已经作废的单据，由于不能彻底删除，故需要在此将库存加回去.
		stockService.addStockQuantity(stock_id, outStock.getOutstock_quantity());
		return outStockDao.nullify(outstock_id);
	}

}
