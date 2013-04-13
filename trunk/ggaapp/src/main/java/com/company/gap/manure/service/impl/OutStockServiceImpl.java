package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.Status;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IRegisterService;
import com.company.gap.manure.dao.IOutStockDao;
import com.company.gap.manure.model.OutStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IOutStockService;
import com.company.gap.manure.service.IStockService;

@Service
public class OutStockServiceImpl extends BaseServiceImpl<OutStock> implements IOutStockService {

	@Autowired
	private IOutStockDao<OutStock> dao;
	@Autowired
	private IStockService stockService;
	@Autowired
	private IRegisterService registerService;
	
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
		double diff = outStock.getQuantity() - outStock.get__added().getDouble("quantity");
		if (diff != 0) {
			stockService.addStockQuantity(stockId, -diff);
		}
		
		return ret;
	}
	
	@Override
	public int approve(Integer id) {
		OutStock outstock = new OutStock();
		outstock.setId(id);
		outstock.setStatus(Status.APPROVED.getStatus());
		return dao.update(outstock);
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