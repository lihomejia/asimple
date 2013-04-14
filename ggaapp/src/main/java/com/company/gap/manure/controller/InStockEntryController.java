package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.service.IInStockService;
import com.company.gap.manure.service.IResourceService;

@Controller
@RequestMapping("manure/instock")
public class InStockEntryController extends EntryController {

	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IInStockService inStockService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		InStock inStock = new InStock();
		inStock.setInuserId(10001);
		inStock.get__added().put("inuserId", "XXX");
		request.setAttribute("data", inStock);
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, InStock inStock) {
		super.save(request);
		inStockService.save(inStock);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		InStock inStock = inStockService.findById(id);
		Dto __added = inStock.get__added();
		__added.put("indate", DateUtils.format(inStock.getIndate()));
		__added.put("expirydate", DateUtils.format(inStock.getExpirydate()));
		__added.put("inuserId", "XXX");
		request.setAttribute("data", inStock);
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		return result;
	}
	
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		inStockService.approve(id);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		inStockService.nullify(id);
		return "redirect:/manure/instock/list.html";
	}
	
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME));
		request.setAttribute("specList", 	resourceService.queryByType(ResourceType.SPEC));
		request.setAttribute("batchList", 	resourceService.queryByType(ResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(ResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(ResourceType.KIND));
	}
}