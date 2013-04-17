package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.Status;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.manure.dao.IManureOutStockDao;
import com.company.gap.manure.model.OutStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;

@Service
public class ManureOutStockServiceImpl extends BaseServiceImpl<OutStock> implements IManureOutStockService {

	@Autowired
	private IManureOutStockDao<OutStock> dao;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	
	protected IBaseDao<OutStock> get() {
		return this.dao;
	}

	@Override
	public int save(OutStock outStock) {
		int stockId = outStock.getStockId();
		Stock stock = stockService.findById(stockId);

		outStock.setNameId(stock.getNameId());
		outStock.setSpecId(stock.getSpecId());
		outStock.setBatchId(stock.getBatchId());
		outStock.setProducerId(stock.getProducerId());
		outStock.setKindId(stock.getKindId());
		
		int ret = 0;
		if (outStock.getId() == null) {
			int registerId = outStock.getRegisterId();
			Register register = registerService.findById(registerId);
			outStock.setCellId(register.getCellId());
			
			ret = dao.insert(outStock);
		} else {
			ret = dao.update(outStock);
		}
		double diff = outStock.getQuantity() - outStock.get__disp().getDouble("quantity");
		if (diff != 0) {
			stockService.addStockQuantity(stockId, -diff);
		}
		
		return ret;
	}
	
	@Override
	public int nullify(Integer id) {
		OutStock outStock = dao.findById(id);
		int stockId = outStock.getStockId();
		//对于已经作废的单据，由于不能彻底删除，故需要在此将库存加回去.
		stockService.addStockQuantity(stockId, outStock.getQuantity());
		outStock.setStatus(Status.NULLIFY.getStatus());
		return dao.update(outStock);
	}
}