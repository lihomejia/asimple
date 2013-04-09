package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.service.IManureStockService;
import com.company.gap.manure.tab.TOutStock;
import com.company.gap.manure.tab.TStock;

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
		request.setAttribute("registerList", 	registerService.findGrowingInfos());
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request){
		int stock_id = NumberUtils.toInt(request.getParameter(TOutStock.STOCKID));
		double quantity = NumberUtils.toDouble(request.getParameter(TOutStock.QUANTITY));
		Dto stock = stockService.findStockById(stock_id);
		return (stock != null) && (stock.getDouble(TStock.QUANTITY) >= quantity);
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		outStockService.save(model.getData());
		return "redirect:/manure/outstock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		super.edit(request);
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		
		Dto outStock = outStockService.findOutStockById(outstock_id);
		
		Dto stock = stockService.findStockById(outStock.getInt(TOutStock.STOCKID));
		StringBuffer stockid__disp = new StringBuffer();
		stockid__disp.
			append(resId2Name.get(stock.getInt(TStock.NAMEID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.SIZEID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.BATCHID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.PRODUCERID))).append("&nbsp;")
			.toString()
		;
		outStock.put("outstock_stockid__disp", stockid__disp);
		
		Dto cell = cellService.findCellById(outStock.getInt(TOutStock.CELLID));
		outStock.put("outstock_registerid__disp", ObjectUtils.toString(cell.get("cell_code")) + "&nbsp;" + cell.get("cell_location"));
		
		request.setAttribute("data", outStock);
		return "manure/outstock/manureOutStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		super.disp(request);
		Map<Integer, String> resId2Name = resourceService.queryResId2Name();
		
		Dto outStock = outStockService.findOutStockById(outstock_id);
		
		Dto stock = stockService.findStockById(outStock.getInt(TOutStock.STOCKID));
		StringBuffer stockid__disp = new StringBuffer();
		stockid__disp.
			append(resId2Name.get(stock.getInt(TStock.NAMEID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.SIZEID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.BATCHID))).append("&nbsp;")
			.append(resId2Name.get(stock.getInt(TStock.PRODUCERID))).append("&nbsp;")
			.toString()
		;
		outStock.put("outstock_stockid__disp", stockid__disp);
		
		Dto cell = cellService.findCellById(outStock.getInt(TOutStock.CELLID));
		outStock.put("outstock_registerid__disp", ObjectUtils.toString(cell.get("cell_code")) + "&nbsp;" + cell.get("cell_location"));
		
		request.setAttribute("data", outStock);
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
	}
}
