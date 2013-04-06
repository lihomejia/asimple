package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.grow.tab.TRegister;
import com.company.gap.manure.dao.IManureOutStockDao;
import com.company.gap.manure.enumeration.ManureOutStockStatus;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;
import com.company.gap.manure.tab.TOutStock;
import com.company.gap.manure.tab.TStock;

@Service
public class ManureOutStockServiceImpl implements IManureOutStockService {

	@Autowired
	private IManureOutStockDao outStockDao;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	
	@Override
	public Dto findOutStockById(int outstock_id) {
		return outStockDao.findInStockById(outstock_id);
	}

	@Override
	public int save(Dto outStock) {
		int stock_id = outStock.getInt(TOutStock.STOCKID);
		Dto stock = stockService.findStockById(stock_id);
		
		outStock.put(TOutStock.NAMEID, stock.getInt(TStock.NAMEID));
		outStock.put(TOutStock.SIZEID, stock.getInt(TStock.SIZEID));
		outStock.put(TOutStock.BATCHID, stock.getInt(TStock.BATCHID));
		outStock.put(TOutStock.PRODUCERID, stock.getInt(TStock.PRODUCERID));
		outStock.put(TOutStock.KINDID, stock.getInt(TStock.KINDID));
		
		int ret = 0;
		if (outStock.getInt(TOutStock.ID)== 0) {
			int registerId = outStock.getInt(TOutStock.REGISTERID);
			Dto register = registerService.findGrowRegister(registerId);
			outStock.put(TOutStock.CELLID, register.getInt(TRegister.CELLID));
			
			ret = outStockDao.insert(outStock);
		} else {
			ret = outStockDao.update(outStock);
		}
		double diff = outStock.getDouble(TOutStock.QUANTITY) - outStock.getDouble("outstock_oquantity");
		if (diff != 0) {
			stockService.addStockQuantity(stock_id, -diff);
		}
		
		return ret;
	}
	

	@Override
	public int delete(int outstock_id) {
		Dto outStock = this.findOutStockById(outstock_id);
		if (outStock.getInt(TOutStock.STATUS) != ManureOutStockStatus.UNAUDITED.getStatus()) {
			//只能删除未审核的
			return 0;
		}
		int stock_id = outStock.getInt(TOutStock.STOCKID);
		//彻底删除，故需要在此将库存加回去.
		stockService.addStockQuantity(stock_id, outStock.getDouble(TOutStock.QUANTITY));
		return outStockDao.delete(outstock_id);
	}
	
	@Override
	public int auditing(int outstock_id) {
		Dto outStock = this.findOutStockById(outstock_id);
		if (outStock.getInt(TOutStock.STATUS) != 0) {
			//已审核，直接返回
			return 0;
		}
		return outStockDao.auditing(outstock_id);
	}

	@Override
	public int nullify(int outstock_id) {
		Dto outStock = this.findOutStockById(outstock_id);
		if (outStock.getInt(TOutStock.STATUS) != 1) {
			//只处理已审核的
			return 0;
		}
		int stock_id = outStock.getInt(TOutStock.STOCKID);
		//对于已经作废的单据，由于不能彻底删除，故需要在此将库存加回去.
		stockService.addStockQuantity(stock_id, outStock.getDouble(TOutStock.QUANTITY));
		return outStockDao.nullify(outstock_id);
	}

}
