package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.LocalContext;
import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.system.service.IUserService;

@Controller
@RequestMapping("admin/manure/instock")
public class ManureInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IManureInStockService service;
	
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/manure/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/manure/instock/manureInStockEntry";
	}
	
	
	
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		InStock t = new InStock();
		t.setInuserId(LocalContext.getLoginId());
		t.getDisp().put("inuserId", LocalContext.getUserName());
		
		request.setAttribute("data", t);
		super.initializeAdd(request);
	}

	@Override
	protected void initializeEdit(HttpServletRequest request, InStock t) {
		Dto disp = t.getDisp();
		disp.put("indate", DateUtils.format(t.getIndate()));
		disp.put("expirydate", DateUtils.format(t.getExpirydate()));
		disp.put("inuserId", userService.findNameById(t.getInuserId()));
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	ManureResourceHelper.getList(ManureResourceType.PM));
		request.setAttribute("specList", 	ManureResourceHelper.getList(ManureResourceType.GG));
		request.setAttribute("batchList", 	ManureResourceHelper.getList(ManureResourceType.SCPH));
		request.setAttribute("producerList",ManureResourceHelper.getList(ManureResourceType.SCS));
		request.setAttribute("kindList", 	ManureResourceHelper.getList(ManureResourceType.ZL));
	}
}