package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.manure.entity.ManureOutStock;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.service.IManureOutStockService;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.service.IManureStockService;

@Controller
@RequestMapping("manure/outstock")
public class ManureOutStockController extends ViewController {
	
	@Autowired
	private IManureOutStockService outStockService;
	@Autowired
	private IManureStockService stockService;
	
	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.setTable("t_manure_outstock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Map<String, Object> data : datas) {
			data.put("outstock_nameid__disp", 	resId2Res.get((Integer) data.get("outstock_nameid")));
			data.put("outstock_sizeid__disp", 	resId2Res.get((Integer) data.get("outstock_sizeid")));
			data.put("outstock_batchid__disp", 	resId2Res.get((Integer) data.get("outstock_batchid")));
			data.put("outstock_producerid__disp",resId2Res.get((Integer) data.get("outstock_producerid")));
			data.put("outstock_indate__disp", 	DateUtils.format(data.get("outstock_indate")));
			ManureInStockStatus status = ManureInStockStatus.valueOf((Integer) data.get("outstock_status"));
			data.put("outstock_status__disp", 	status.getName());
		}
	}
	
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
		request.setAttribute("stocks", stockService.queryAllStock());
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
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("outstock_id") int outstock_id) {
		outStockService.auditing(outstock_id);
		return "redirect:/manure/outstock/list.html";
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/outstock/manureOutStockList";
	}
}
