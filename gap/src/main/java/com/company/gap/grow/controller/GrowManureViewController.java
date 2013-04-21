package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.model.Manure;

@Controller
@RequestMapping("grow/manure")
public class GrowManureViewController extends BeanViewController<Manure> {

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
		for (Manure farm : datas) {
			Dto __disp = farm.get__disp();
			__disp.put("usedate", DateUtils.format(farm.getUsedate()));
			__disp.put("status", Status.valueOf(farm.getStatus()).getName());
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/manure/growManureList";
	}
}