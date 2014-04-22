package com.company.gap.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.LocalContext;
import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.component.FeedResourceHelper;
import com.company.gap.feed.enumeration.FeedResourceType;
import com.company.gap.feed.model.InStock;
import com.company.gap.feed.service.IFeedInStockService;
import com.company.gap.system.service.IUserService;

@Controller
@RequestMapping("admin/feed/instock")
public class FeedInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IFeedInStockService service;
	
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/feed/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/feed/instock/feedInStockEntry";
	}
	
	
	
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		InStock t = new InStock();
		t.setInuserId(LocalContext.getLoginId());
		t.getDisp().put("inuserId", LocalContext.getUserName());
		
		request.setAttribute("data", t);
		super.initializeAdd(request);
	}

	@Override
	protected void initializeEdit(HttpServletRequest request, InStock t) {
		Dto disp = t.getDisp();
		disp.put("indate", DateUtils.format(t.getIndate()));
		disp.put("expirydate", DateUtils.format(t.getExpirydate()));
		disp.put("inuserId", userService.findNameById(t.getInuserId()));
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	FeedResourceHelper.getList(FeedResourceType.PM));
		request.setAttribute("specList", 	FeedResourceHelper.getList(FeedResourceType.GG));
		request.setAttribute("batchList", 	FeedResourceHelper.getList(FeedResourceType.SCPH));
		request.setAttribute("producerList",FeedResourceHelper.getList(FeedResourceType.SCS));
		request.setAttribute("kindList", 	FeedResourceHelper.getList(FeedResourceType.ZL));
	}
}