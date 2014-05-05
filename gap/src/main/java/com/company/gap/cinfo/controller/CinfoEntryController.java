package com.company.gap.cinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;
import com.company.gap.cinfo.service.ICinfoService;

@Controller
@RequestMapping("admin/cinfo")
public class CinfoEntryController extends BeanEntryController<Cinfo> {
	
	@Autowired
	private ICinfoService service;
	
	@Override
	protected IBaseService<Cinfo> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		
		if (CinfoType.GSJJ.toString().equals(type)) {
			return "redirect:/admin/cinfo/edit.html?id=1";
		}
		
		return "redirect:/admin/cinfo/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/cinfo/cinfoEntry";
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", CinfoType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Cinfo t) {
		super.initializeEdit(request, t);
		CinfoType infoType = t.getType();
		request.setAttribute("resourceType", infoType);
		request.setAttribute("type", infoType.toString());
	}
}