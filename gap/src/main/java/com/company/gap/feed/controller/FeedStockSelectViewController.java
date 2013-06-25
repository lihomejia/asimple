package com.company.gap.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.feed.component.FeedResourceHelper;
import com.company.gap.feed.enumeration.FeedResourceType;
import com.company.gap.feed.model.Resource;
import com.company.gap.feed.model.Stock;

@Controller
@RequestMapping("admin/feed/stock/select")
public class FeedStockSelectViewController extends BeanViewController<Stock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	FeedResourceHelper.getList(FeedResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	FeedResourceHelper.getList(FeedResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	FeedResourceHelper.getList(FeedResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",FeedResourceHelper.getList(FeedResourceType.SCS,  Resource.RS_ALL));
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		
		Dto data = model.getData();
		String nameId 		= data.getString("nameId");
		String sizeId 		= data.getString("sizeId");
		String batchId 		= data.getString("batchId");
		String producerId 	= data.getString("producerId");
		if (StringUtils.isNotEmpty(nameId)) 	searcher.addSf(toField("nameId"), Op.EQ, nameId);
		if (StringUtils.isNotEmpty(sizeId)) 	searcher.addSf(toField("sizeId"), Op.EQ, sizeId);
		if (StringUtils.isNotEmpty(batchId)) 	searcher.addSf(toField("batchId"), Op.EQ, batchId);
		if (StringUtils.isNotEmpty(producerId)) searcher.addSf(toField("producerId"), Op.EQ, producerId);
		
		searcher.setAddsql("quantity > 0");
	}

	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Stock t : datas) {
			Dto disp = t.getDisp();
			disp.put("nameId", 		FeedResourceHelper.getText(t.getNameId()));
			disp.put("specId", 		FeedResourceHelper.getText(t.getSpecId()));
			disp.put("batchId", 	FeedResourceHelper.getText(t.getBatchId()));
			disp.put("producerId", 	FeedResourceHelper.getText(t.getProducerId()));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/feed/stock/feedStockSelectList";
	}
}