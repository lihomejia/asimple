package com.company.gap.pesticide.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.pesticide.enumeration.ResourceType;
import com.company.gap.pesticide.model.Resource;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/resource")
public class PesticideResourceEntryController extends BeanEntryController<Resource> {
	
	@Autowired
	private IPesticideResourceService service;
	
	@Override
	protected IBaseService<Resource> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/pesticide/resource/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "pesticide/resource/pesticideResourceEntry";
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("resource", ResourceType.valueOf(type));
		request.setAttribute("type", type);
		
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Resource t) {
		super.initializeEdit(request, t);
		int type = t.getType();
		request.setAttribute("resource", ResourceType.valueOf(type));
		request.setAttribute("type", type);
	}
}