package com.company.gap.info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;
import com.company.gap.info.service.IInfoService;

@Controller
@RequestMapping("admin/info")
public class InfoEntryController extends BeanEntryController<Info> {
	
	@Autowired
	private IInfoService service;
	
	@Override
	protected IBaseService<Info> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/admin/info/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/info/infoEntry";
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", InfoType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Info t) {
		super.initializeEdit(request, t);
		InfoType infoType = t.getType();
		request.setAttribute("resourceType", infoType);
		request.setAttribute("type", infoType.toString());
	}
}