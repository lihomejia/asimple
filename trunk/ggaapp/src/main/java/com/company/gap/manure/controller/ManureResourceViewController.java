package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.manure.enumeration.ManureResourceType;

@Controller
@RequestMapping("manure/resource")
public class ManureResourceViewController extends ViewController {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("type", type);
		request.setAttribute("resource", ManureResourceType.valueOf(type));
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		searcher.addSf("resource_type", Op.EQ, type);
		searcher.setTable("t_manure_resource");
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/resource/manureResourceList";
	}
}