package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Harvest;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IGrowHarvestService;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.resource.component.DictHelper;
import com.company.gap.resource.enumeration.DictType;
import com.company.gap.resource.model.Dict;
import com.company.gap.resource.service.IDictService;

@Controller
@RequestMapping("admin/grow/harvest")
public class GrowHarvestEntryController extends BeanEntryController<Harvest> {
	@Autowired
	private IGrowHarvestService service;
	
	@Autowired
	private IGrowRegisterService growRegisterService;
	
	@Autowired
	private IDictService dictService;
	
	@Override
	protected IBaseService<Harvest> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/admin/grow/harvest/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/grow/harvest/growHarvestEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Harvest t) {
		t.getDisp().put("operatedate", DateUtils.format(t.getOperatedate()));
		super.initializeEdit(request, t);
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		
		Register register = growRegisterService.findById(NumberUtils.toInt(registerId));
		
		Dict dict = dictService.findById(register.getProductId());
		request.setAttribute("productName", dict.getName());
		request.setAttribute("sgffList", DictHelper.getList(DictType.SGFF));
	}
}