package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private IManureInStockService service;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/manure/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "manure/instock/manureInStoctEntry";
	}
	
	
	@Override
	protected void initializeEdit(HttpServletRequest request, InStock t) {
		Dto __disp = t.get__disp();
		__disp.put("indate", DateUtils.format(t.getIndate()));
		__disp.put("expirydate", DateUtils.format(t.getExpirydate()));
		__disp.put("inuserId", "XXX");
		super.initializeEdit(request, t);
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