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
	public int save(OutStock t) {
		int stockId = t.getStockId();
		Stock stock = stockService.findById(stockId);

		t.setNameId(stock.getNameId());
		t.setSpecId(stock.getSpecId());
		t.setBatchId(stock.getBatchId());
		t.setProducerId(stock.getProducerId());
		t.setKindId(stock.getKindId());
		
		Register register = registerService.findById(t.getRegisterId());
		t.setCellId(register.getCellId());
		stockService.addStockQuantity(stockId, -t.getQuantity());
		return dao.insert(t);
	}
	
	@Override
	public int update(OutStock t) {
		double quantity = t.getQuantity();
		double oquantity = t.getDisp().getDouble("quantity");
		stockService.addStockQuantity(t.getStockId(), oquantity - quantity);
		return dao.update(t);
	}
	
	
	@Override
	public int deleteById(Integer id) {
		OutStock outStock = dao.findById(id);
		int stockId = outStock.getStockId();
		//对于彻底删除的出库记录，故需要在此将库存加回去.
		stockService.addStockQuantity(stockId, outStock.getQuantity());
		return dao.deleteById(id);
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