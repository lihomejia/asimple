package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.manure.entity.ManureInStock;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockController extends ViewController {

	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private IManureInStockService inStockService;
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.setTable("t_manure_instock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Map<String, Object> data : datas) {
			data.put("instock_nameid__disp", 	resId2Res.get((Integer) data.get("instock_nameid")));
			data.put("instock_sizeid__disp", 	resId2Res.get((Integer) data.get("instock_sizeid")));
			data.put("instock_batchid__disp", 	resId2Res.get((Integer) data.get("instock_batchid")));
			data.put("instock_producerid__disp",resId2Res.get((Integer) data.get("instock_producerid")));
			data.put("instock_indate__disp", 	DateUtils.format(data.get("instock_indate")));
			ManureInStockStatus status = ManureInStockStatus.valueOf((Integer) data.get("instock_status"));
			data.put("instock_status__disp", 	status.getName());
		}
	}
	
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
		request.setAttribute("nameList", 	resourceService.queryByType(ManureResourceType.NAME));
		request.setAttribute("sizeList", 	resourceService.queryByType(ManureResourceType.SIZE));
		request.setAttribute("batchList", 	resourceService.queryByType(ManureResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(ManureResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(ManureResourceType.KIND));
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, ManureInStock inStock) {
		inStockService.save(inStock);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		return "redirect:/manure/instock/list.html";
	}
	
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.auditing(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.delete(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}