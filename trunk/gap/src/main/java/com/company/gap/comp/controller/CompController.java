package com.company.gap.comp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.comp.model.Comp;
import com.company.gap.comp.service.ICompService;

@Controller
@RequestMapping("admin/comp")
public class CompController extends BeanEntryController<Comp> {
	
	@Autowired
	private ICompService service;
	
	@Override
	protected IBaseService<Comp> get() {return this.service;}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/comp/compEntry";
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Comp t) {
		super.initializeEdit(request, t);
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Comp t) {
		this.get().update(t);
		initializeEdit(request, t);
		return this.toEntry(request);
	}
}