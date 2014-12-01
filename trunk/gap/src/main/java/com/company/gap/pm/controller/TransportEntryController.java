package com.company.gap.pm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.pm.model.Transport;
import com.company.gap.pm.service.ITransportService;
import com.company.gap.resource.component.DictHelper;
import com.company.gap.resource.enumeration.DictType;

@Controller
@RequestMapping("admin/pm/transport")
public class TransportEntryController extends BeanEntryController<Transport> {

	@Autowired
	private ITransportService service;
	
	@Override
	protected IBaseService<Transport> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/pm/transport/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/pm/transport/entry";
	}
	
	
	protected void initializeAdd(HttpServletRequest request) {
		request.setAttribute("cplbList", 	DictHelper.getList(DictType.CPLB));
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Transport t) {
		Dto disp = t.getDisp();
		disp.put("transportdate", DateUtils.format(t.getTransportdate()));
		disp.put("productId", DictHelper.getText(t.getProductId()));
		super.initializeEdit(request, t);
	}
	
}
