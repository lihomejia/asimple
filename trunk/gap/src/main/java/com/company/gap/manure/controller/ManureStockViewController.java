package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.Stock;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/stock")
public class ManureStockViewController extends BeanViewController<Stock> {
	
	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME, true));
		request.setAttribute("specList", 	resourceService.queryByType(ResourceType.SPEC, true));
		request.setAttribute("batchList", 	resourceService.queryByType(ResourceType.BATCH, true));
		request.setAttribute("producerList",resourceService.queryByType(ResourceType.PRODUCER, true));
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		
		Map<String, Object> data = model.getData();
		String nameid 		= ObjectUtils.toString(data.get("nameid"), "0");
		String sizeid 		= ObjectUtils.toString(data.get("sizeid"), "0");
		String batchid 		= ObjectUtils.toString(data.get("batchid"), "0");
		String producerid 	= ObjectUtils.toString(data.get("producerid"), "0");
		if (!"0".equals(nameid)) 	searcher.addSf("stock_nameid", Op.EQ, nameid);
		if (!"0".equals(sizeid)) 	searcher.addSf("stock_sizeid", Op.EQ, sizeid);
		if (!"0".equals(batchid)) 	searcher.addSf("stock_batchid", Op.EQ, batchid);
		if (!"0".equals(producerid))searcher.addSf("stock_producerid", Op.EQ, producerid);
	}

	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Stock stock : datas) {
			Dto __disp = stock.get__disp();
			__disp.put("nameId", 		resId2Res.get(stock.getNameId()));
			__disp.put("specId", 		resId2Res.get(stock.getSpecId()));
			__disp.put("batchId", 		resId2Res.get(stock.getBatchId()));
			__disp.put("producerId",	resId2Res.get(stock.getProducerId()));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/stock/manureStockList";
	}

}
