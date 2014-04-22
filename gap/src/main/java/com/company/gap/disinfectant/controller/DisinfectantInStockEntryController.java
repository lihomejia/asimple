package com.company.gap.disinfectant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.LocalContext;
import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.disinfectant.component.DisinfectantResourceHelper;
import com.company.gap.disinfectant.enumeration.DisinfectantResourceType;
import com.company.gap.disinfectant.model.InStock;
import com.company.gap.disinfectant.service.IDisinfectantInStockService;
import com.company.gap.system.service.IUserService;

@Controller
@RequestMapping("admin/disinfectant/instock")
public class DisinfectantInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IDisinfectantInStockService service;
	
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/disinfectant/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/disinfectant/instock/disinfectantInStockEntry";
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
		request.setAttribute("nameList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.PM));
		request.setAttribute("specList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.GG));
		request.setAttribute("batchList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.SCPH));
		request.setAttribute("producerList",DisinfectantResourceHelper.getList(DisinfectantResourceType.SCS));
		request.setAttribute("kindList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.ZL));
	}
}