package com.company.gap.nurture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.nurture.model.Pesticide;

@Controller
@RequestMapping("admin/nurture/pesticide")
public class NurturePesticideViewController extends BeanViewController<Pesticide> {

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
		for (Pesticide farm : datas) {
			Dto disp = farm.getDisp();
			disp.put("usedate", DateUtils.format(farm.getUsedate()));
			disp.put("status", Status.valueOf(farm.getStatus()).getName());
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/nurture/pesticide/nurturePesticideList";
	}
}