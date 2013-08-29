package com.company.gap.resource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.resource.enumeration.DictType;
import com.company.gap.resource.model.Dict;

@Controller
@RequestMapping("admin/resource/dict")
public class DictViewController extends BeanViewController<Dict> {

	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		request.setAttribute("dict", DictType.valueOf(type));
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		searcher.addSf("type", Op.EQ, type);
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Dict dict : datas) {
			Dto disp = dict.getDisp();
			disp.put("status", Status.valueOf(dict.getStatus()).getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/resource/dict/list";
	}
}