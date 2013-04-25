package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Farm;
import com.company.gap.grow.service.IGrowFarmService;

@Controller
@RequestMapping("grow/farm")
public class GrowFarmEntryController extends BeanEntryController<Farm> {

	@Autowired
	private IGrowFarmService service;
	
	@Override
	protected IBaseService<Farm> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/farm/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "grow/farm/growFarmEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Farm t) {
		t.getDisp().put("activitydate", DateUtils.format(t.getActivitydate()));
		super.initializeEdit(request, t);
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}