package com.company.gap.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.enumeration.FeedResourceType;
import com.company.gap.feed.model.Resource;

@Controller
@RequestMapping("admin/feed/resource")
public class FeedResourceViewController extends BeanViewController<Resource> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		request.setAttribute("resource", FeedResourceType.valueOf(type));
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		searcher.addSf("type", Op.EQ, type);
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Resource resource : datas) {
			Dto disp = resource.getDisp();
			disp.put("status", Status.valueOf(resource.getStatus()).getName());
		}
	} 

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/feed/resource/feedResourceList";
	}
}