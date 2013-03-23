package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/stock")
public class ManureStockController extends ViewController {

	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.setTable("t_manure_stock");
	}

	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Map<String, Object> data : datas) {
			data.put("stock_nameid__disp", 		resId2Res.get((Integer) data.get("stock_nameid")));
			data.put("stock_sizeid__disp", 		resId2Res.get((Integer) data.get("stock_sizeid")));
			data.put("stock_batchid__disp", 	resId2Res.get((Integer) data.get("stock_batchid")));
			data.put("stock_producerid__disp",	resId2Res.get((Integer) data.get("stock_producerid")));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/stock/manureStockList";
	}

}
