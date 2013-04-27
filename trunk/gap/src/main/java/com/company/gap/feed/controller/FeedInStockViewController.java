package com.company.gap.feed.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.enumeration.ResourceType;
import com.company.gap.feed.model.InStock;
import com.company.gap.feed.service.IFeedResourceService;

@Controller
@RequestMapping("feed/instock")
public class FeedInStockViewController extends BeanViewController<InStock> {

	@Autowired
	private IFeedResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME, true));
		request.setAttribute("specList", 	resourceService.queryByType(ResourceType.SPEC, true));
		request.setAttribute("batchList", 	resourceService.queryByType(ResourceType.BATCH, true));
		request.setAttribute("producerList",resourceService.queryByType(ResourceType.PRODUCER, true));
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
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (InStock inStock : datas) {
			Dto disp = inStock.getDisp();
			disp.put("nameId", 		resId2Res.get(inStock.getNameId()));
			disp.put("specId", 		resId2Res.get(inStock.getSpecId()));
			disp.put("batchId", 	resId2Res.get(inStock.getBatchId()));
			disp.put("producerId", 	resId2Res.get(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "feed/instock/feedInStockList";
	}
}