package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.service.IResourceService;

@Controller
@RequestMapping("manure/stock")
public class StockController extends ViewController {

	@Autowired
	private IResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME, true));
		request.setAttribute("sizeList", 	resourceService.queryByType(ResourceType.SPEC, true));
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
		
		searcher.setTable("t_manure_stock");
	}

	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Dto dto : datas) {
			dto.put("stock_nameid__disp", 		resId2Res.get(dto.getInt("stock_nameid")));
			dto.put("stock_sizeid__disp", 		resId2Res.get(dto.getInt("stock_sizeid")));
			dto.put("stock_batchid__disp", 		resId2Res.get(dto.getInt("stock_batchid")));
			dto.put("stock_producerid__disp",	resId2Res.get(dto.getInt("stock_producerid")));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/stock/manureStockList";
	}

}
