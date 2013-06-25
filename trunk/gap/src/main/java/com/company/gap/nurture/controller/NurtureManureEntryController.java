package com.company.gap.nurture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.nurture.model.Manure;
import com.company.gap.nurture.service.INurtureManureService;
import com.company.gap.resource.component.DictHelper;
import com.company.gap.resource.enumeration.DictType;

@Controller
@RequestMapping("admin/nurture/manure")
public class NurtureManureEntryController extends BeanEntryController<Manure> {

	@Autowired
	private INurtureManureService service;
	
	@Override
	protected IBaseService<Manure> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/admin/nurture/manure/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/nurture/manure/nurtureManureEntry";
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
		request.setAttribute("nameList", ManureResourceHelper.getList(ManureResourceType.PM));
		request.setAttribute("jxlbList", DictHelper.getList(DictType.JXLB));
		request.setAttribute("syffList", DictHelper.getList(DictType.SYFF));
	}
}