package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.model.Manure;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.resource.service.impl.DictHelper;

@Controller
@RequestMapping("grow/manure")
public class GrowManureViewController extends BeanViewController<Manure> {

	@Autowired
	private IManureResourceService manureResourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		searcher.addSf("register_id", Op.EQ, registerId);
	}

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Manure t : datas) {
			Dto disp = t.getDisp();
			disp.put("usedate", DateUtils.format(t.getUsedate()));
			disp.put("status", Status.valueOf(t.getStatus()).getName());
			disp.put("nameId", manureResourceService.findById(t.getNameId()).getName());
			disp.put("machinecate", DictHelper.getText(t.getMachinecate()));
			disp.put("method", DictHelper.getText(t.getMethod()));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/manure/growManureList";
	}
}