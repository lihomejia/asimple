package com.company.gap.nurture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.nurture.model.Harvest;
import com.company.gap.nurture.service.INurtureHarvestService;

@Controller
@RequestMapping("nurture/harvest")
public class NurtureHarvestEntryController extends BeanEntryController<Harvest> {
	@Autowired
	private INurtureHarvestService service;
	
	@Override
	protected IBaseService<Harvest> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/nurture/harvest/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "nurture/harvest/nurtureHarvestEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Harvest t) {
		t.getDisp().put("operatedate", DateUtils.format(t.getOperatedate()));
		super.initializeEdit(request, t);
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}