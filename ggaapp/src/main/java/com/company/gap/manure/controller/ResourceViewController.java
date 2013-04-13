package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.Resource;

@Controller
@RequestMapping("manure/resource")
public class ResourceViewController extends BeanViewController<Resource> {
	
	public ResourceViewController() {
		super(Resource.class);
	}

	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("type", type);
		request.setAttribute("resource", ResourceType.valueOf(type));
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		searcher.addSf("type", Op.EQ, type);
		searcher.setTable("t_manure_resource");
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/resource/manureResourceList";
	}
}