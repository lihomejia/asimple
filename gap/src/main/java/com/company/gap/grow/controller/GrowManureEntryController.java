package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Manure;
import com.company.gap.grow.service.IGrowManureService;

@Controller
@RequestMapping("grow/manure")
public class GrowManureEntryController extends BeanEntryController<Manure> {

	@Autowired
	private IGrowManureService service;
	
	@Override
	protected IBaseService<Manure> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/manure/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "grow/manure/growManureEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Manure t) {
		t.getDisp().put("usedate", DateUtils.format(t.getUsedate()));
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}