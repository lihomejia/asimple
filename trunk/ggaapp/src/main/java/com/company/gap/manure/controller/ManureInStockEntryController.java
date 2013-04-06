package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockEntryController extends EntryController {

	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private IManureInStockService inStockService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		super.save(request);
		Dto data = model.getData();
		inStockService.save(data);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		super.edit(request);
		Dto inStock = inStockService.findInStockById(instock_id);
		request.setAttribute("data", inStock);
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		super.disp(request);
		Dto inStock = inStockService.findInStockById(instock_id);
		request.setAttribute("data", inStock);
		return "manure/instock/manureInStoctEntry";
	}
	
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.auditing(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.nullify(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		super.delete(request);
		inStockService.delete(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	resourceService.queryByType(ManureResourceType.NAME));
		request.setAttribute("sizeList", 	resourceService.queryByType(ManureResourceType.SIZE));
		request.setAttribute("batchList", 	resourceService.queryByType(ManureResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(ManureResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(ManureResourceType.KIND));
	}
}