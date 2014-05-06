package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Pesticide;
import com.company.gap.grow.service.IGrowPesticideService;
import com.company.gap.resource.component.DictHelper;
import com.company.gap.resource.enumeration.DictType;

@Controller
@RequestMapping("admin/grow/pesticide")
public class GrowPesticideEntryController extends BeanEntryController<Pesticide> {

	@Autowired
	private IGrowPesticideService service;
	
	@Override
	protected IBaseService<Pesticide> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String registerId = request.getParameter("registerId");
		return "redirect:/admin/grow/pesticide/list.html?registerId=" + registerId;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/grow/pesticide/growPesticideEntry";
	}
	
	@Override
	public void initializeEdit(HttpServletRequest request, Pesticide t) {
		t.getDisp().put("usedate", DateUtils.format(t.getUsedate()));
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
		request.setAttribute("jxlbList", DictHelper.getList(DictType.JXLB));
		request.setAttribute("syffList", DictHelper.getList(DictType.SYFF));
	}
}