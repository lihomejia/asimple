package com.company.gap.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.enumeration.ResourceType;
import com.company.gap.feed.model.InStock;
import com.company.gap.feed.service.IFeedInStockService;
import com.company.gap.feed.service.IFeedResourceService;

@Controller
@RequestMapping("feed/instock")
public class FeedInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IFeedResourceService resourceService;
	@Autowired
	private IFeedInStockService service;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/feed/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "feed/instock/feedInStoctEntry";
	}
	
	
	@Override
	protected void initializeEdit(HttpServletRequest request, InStock t) {
		Dto disp = t.getDisp();
		disp.put("indate", DateUtils.format(t.getIndate()));
		disp.put("expirydate", DateUtils.format(t.getExpirydate()));
		disp.put("inuserId", "XXX");
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME));
		request.setAttribute("specList", 	resourceService.queryByType(ResourceType.SPEC));
		request.setAttribute("batchList", 	resourceService.queryByType(ResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(ResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(ResourceType.KIND));
	}
}