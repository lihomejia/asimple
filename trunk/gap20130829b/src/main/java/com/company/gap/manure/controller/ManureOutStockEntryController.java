package com.company.gap.manure.controller;

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
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.model.OutStock;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;
import com.company.gap.system.service.IUserService;
import com.company.gap.system.service.impl.ServiceContext;

@Controller
@RequestMapping("admin/manure/outstock")
public class ManureOutStockEntryController extends BeanEntryController<OutStock> {
	
	@Autowired
	private IManureOutStockService service;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private ICellService cellService;
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<OutStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/manure/outstock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/manure/outstock/manureOutStockEntry";
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
		OutStock t = new OutStock();
		t.setOutuserId(ServiceContext.getLoginId());
		t.getDisp().put("outuserId", ServiceContext.getUserName());
		request.setAttribute("data", t);
		request.setAttribute("registerList", 	registerService.findListByGrowStatus(GrowStatus.GOING.getStatus()));
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, OutStock t) {
		
		Dto disp = t.getDisp();
		
		disp.put("nameId", 		ManureResourceHelper.getText(t.getNameId()));
		disp.put("specId", 		ManureResourceHelper.getText(t.getSpecId()));
		disp.put("batchId", 	ManureResourceHelper.getText(t.getBatchId()));
		disp.put("producerId", 	ManureResourceHelper.getText(t.getProducerId()));
		
		Cell cell = cellService.findById(t.getCellId());
		disp.put("outdate", DateUtils.format(t.getOutdate()));
		disp.put("registerId", cell.getCode() + "&nbsp;" + cell.getLocation());
		disp.put("outuserId", userService.findNameById(t.getOutuserId()));
		super.initializeEdit(request, t);
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
	}
}