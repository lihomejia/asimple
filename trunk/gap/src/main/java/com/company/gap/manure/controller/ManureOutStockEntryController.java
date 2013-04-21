package com.company.gap.manure.controller;

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
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.manure.model.OutStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.service.IManureStockService;

@Controller
@RequestMapping("manure/outstock")
public class ManureOutStockEntryController extends BeanEntryController<OutStock> {
	
	@Autowired
	private IManureOutStockService service;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private ICellService cellService;
	
	@Override
	protected IBaseService<OutStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/manure/outstock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request){
		int stockId = NumberUtils.toInt(request.getParameter("stockId"));
		double quantity = NumberUtils.toDouble(request.getParameter("quantity"));
		Stock stock = stockService.findById(stockId);
		return (stock != null) && (stock.getQuantity() >= quantity);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initializeAdd(request);
		request.setAttribute("registerList", 	registerService.findListByGrowStatus(GrowStatus.GOING.getStatus()));
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, OutStock t) {
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		
		Stock stock = stockService.findById(t.getStockId());
		StringBuffer stockId__disp = new StringBuffer();
		stockId__disp.
			append(resId2Name.get(stock.getNameId())).append("&nbsp;")
			.append(resId2Name.get(stock.getSpecId())).append("&nbsp;")
			.append(resId2Name.get(stock.getBatchId())).append("&nbsp;")
			.append(resId2Name.get(stock.getProducerId())).append("&nbsp;")
			.toString()
		;
		t.get__disp().put("stockId", stockId__disp);
		
		Cell cell = cellService.findById(t.getCellId());
		t.get__disp().put("outdate", DateUtils.format(t.getOutdate()));
		t.get__disp().put("registerId", cell.getCode() + "&nbsp;" + cell.getLocation());
		super.initializeEdit(request, t);
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("stocks", 		stockService.findStockList());
	}
}