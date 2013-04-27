package com.company.gap.medicine.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.medicine.model.OutStock;
import com.company.gap.medicine.model.Stock;
import com.company.gap.medicine.service.IMedicineOutStockService;
import com.company.gap.medicine.service.IMedicineResourceService;
import com.company.gap.medicine.service.IMedicineStockService;

@Controller
@RequestMapping("medicine/outstock")
public class MedicineOutStockEntryController extends BeanEntryController<OutStock> {
	
	@Autowired
	private IMedicineOutStockService service;
	@Autowired
	private IMedicineStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private IMedicineResourceService resourceService;
	@Autowired
	private ICellService cellService;
	
	@Override
	protected IBaseService<OutStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/medicine/outstock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "medicine/outstock/medicineOutStoctEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request){
		int stockId = NumberUtils.toInt(request.getParameter("stockId"));
		double quantity = NumberUtils.toDouble(request.getParameter("quantity"));
		Stock stock = stockService.findById(stockId);
		return (stock != null) && (stock.getQuantity() >= quantity);
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, OutStock t) {
		this.get().update(t);
		return this.toList(request);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initializeAdd(request);
		request.setAttribute("registerList", 	registerService.findListByGrowStatus(GrowStatus.GOING.getStatus()));
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, OutStock t) {
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		
		Dto disp = t.getDisp();
		
		disp.put("nameId", 		resId2Name.get(t.getNameId()));
		disp.put("specId", 		resId2Name.get(t.getSpecId()));
		disp.put("batchId", 	resId2Name.get(t.getBatchId()));
		disp.put("producerId", 	resId2Name.get(t.getProducerId()));
		
		Cell cell = cellService.findById(t.getCellId());
		disp.put("outdate", DateUtils.format(t.getOutdate()));
		disp.put("registerId", cell.getCode() + "&nbsp;" + cell.getLocation());
		super.initializeEdit(request, t);
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("stocks", 		stockService.findStockList());
	}
}