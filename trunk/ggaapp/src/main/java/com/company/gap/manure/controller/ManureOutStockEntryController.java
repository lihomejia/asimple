package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.EntryController;
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
public class ManureOutStockEntryController extends EntryController {
	
	@Autowired
	private IManureOutStockService outStockService;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private ICellService cellService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		request.setAttribute("registerList", 	registerService.findListByGrowStatus(GrowStatus.GOING.getStatus()));
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request){
		int stockId = NumberUtils.toInt(request.getParameter("stockId"));
		double quantity = NumberUtils.toDouble(request.getParameter("quantity"));
		Stock stock = stockService.findById(stockId);
		return (stock != null) && (stock.getQuantity() >= quantity);
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, OutStock outStock) {
		outStockService.save(outStock);
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		
		OutStock outStock = outStockService.findById(id);
		
		Stock stock = stockService.findById(outStock.getStockId());
		StringBuffer stockId__disp = new StringBuffer();
		stockId__disp.
			append(resId2Name.get(stock.getNameId())).append("&nbsp;")
			.append(resId2Name.get(stock.getSpecId())).append("&nbsp;")
			.append(resId2Name.get(stock.getBatchId())).append("&nbsp;")
			.append(resId2Name.get(stock.getProducerId())).append("&nbsp;")
			.toString()
		;
		outStock.get__added().put("stockId", stockId__disp);
		
		Cell cell = cellService.findById(outStock.getCellId());
		outStock.get__added().put("outstock_registerid__disp", cell.getCode() + "&nbsp;" + cell.getLocation());
		
		request.setAttribute("data", outStock);
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		
		return result;
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		outStockService.approve(id);
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		outStockService.nullify(id);
		return "redirect:/manure/outstock/list.html";
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("stocks", 		stockService.findStockList());
	}
}
