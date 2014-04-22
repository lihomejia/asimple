package com.company.gap.backend.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("backend/company")
public class BackendCompanyEntryController extends BeanEntryController<Company> {
	
	@Autowired
	private IBackendCompanyService service;
	
	@Override
	protected IBaseService<Company> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/backend/company/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "backend/company/entry";
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Company t) {
		super.initializeEdit(request, t);
	}
}