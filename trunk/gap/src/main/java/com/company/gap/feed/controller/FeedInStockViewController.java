package com.company.gap.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.component.FeedResourceHelper;
import com.company.gap.feed.enumeration.FeedResourceType;
import com.company.gap.feed.model.InStock;
import com.company.gap.feed.model.Resource;

@Controller
@RequestMapping("admin/feed/instock")
public class FeedInStockViewController extends BeanViewController<InStock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	FeedResourceHelper.getList(FeedResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	FeedResourceHelper.getList(FeedResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	FeedResourceHelper.getList(FeedResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",FeedResourceHelper.getList(FeedResourceType.SCS,  Resource.RS_ALL));
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String stockId = request.getParameter("stockId");
		if (StringUtils.isNotEmpty(stockId)) {
			request.setAttribute("stockId", stockId);
			searcher.addSf(toField("stockId"), Op.EQ, stockId);
		}
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (InStock inStock : datas) {
			Dto disp = inStock.getDisp();
			disp.put("nameId", 		FeedResourceHelper.getText(inStock.getNameId()));
			disp.put("specId", 		FeedResourceHelper.getText(inStock.getSpecId()));
			disp.put("batchId", 	FeedResourceHelper.getText(inStock.getBatchId()));
			disp.put("producerId", 	FeedResourceHelper.getText(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/feed/instock/feedInStockList";
	}
}