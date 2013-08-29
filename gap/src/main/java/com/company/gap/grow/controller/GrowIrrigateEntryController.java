package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Irrigate;
import com.company.gap.grow.service.IGrowIrrigateService;

@Controller
@RequestMapping("admin/grow/irrigate")
public class GrowIrrigateEntryController extends BeanEntryController<Irrigate> {
	@Autowired
	private IGrowIrrigateService service;
	
	@Override
	protected IBaseService<Irrigate> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/admin/grow/irrigate/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/grow/irrigate/growIrrigateEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Irrigate t) {
		t.getDisp().put("date", DateUtils.format(t.getDate()));
		super.initializeEdit(request, t);
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}