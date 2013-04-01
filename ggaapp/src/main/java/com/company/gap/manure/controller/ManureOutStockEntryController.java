package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.EntryController;
import com.company.gap.cell.service.ICellService;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureStockService;

@Controller
@RequestMapping("manure/outstock")
public class ManureOutStockEntryController extends EntryController {
	
	@Autowired
	private IManureOutStockService outStockService;
	@Autowired
	private IManureStockService stockService;
	@Autowired
	private ICellService cellService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		request.setAttribute("outStock", new ManureOutStock());
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request, ManureOutStock outStock){
		int stock_id = outStock.getOutstock_stockid();
		double quantity = outStock.getOutstock_quantity();
		ManureStock stock = stockService.findStockById(stock_id);
		return (stock != null) && (stock.getStock_quantity() >= quantity);
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, ManureOutStock outStock) {
		outStockService.save(outStock);
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		super.edit(request);
		ManureOutStock outStock = outStockService.findOutStockById(outstock_id);
		request.setAttribute("outStock", outStock);
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		super.disp(request);
		ManureOutStock outStock = outStockService.findOutStockById(outstock_id);
		request.setAttribute("outStock", outStock);
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		outStockService.auditing(outstock_id);
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		outStockService.nullify(outstock_id);
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		super.delete(request);
		outStockService.delete(outstock_id);
		return "redirect:/manure/outstock/list.html";
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("stocks", 		stockService.queryAllStock());
		request.setAttribute("cellList", 	cellService.findAllProductionCell());
	}
}
