package com.company.gap.web.info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;
import com.company.gap.info.service.IInfoService;

@Controller
@RequestMapping("web/info")
public class InfoController extends BeanViewController<Info> {
	
	@Autowired
	private IInfoService service;
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, Integer id) {
		Info info = service.findById(id);
		request.setAttribute("info", info);
		
		return "web/info/infoDetail";
	}
	
	

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		InfoType infoType = InfoType.valueOf(type);
		searcher.addSf("type", Op.EQ, type);
		request.setAttribute("infoType", infoType);
	}




	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "web/info/infoList";
	}
}
