package com.company.gap.pesticide.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.pesticide.entity.PesticideResource;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/stock")
public class PesticideStockController extends ViewController {

	@Autowired
	private IPesticideResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(PesticideResourceType.NAME, PesticideResource.ALL));
		request.setAttribute("sizeList", 	resourceService.queryByType(PesticideResourceType.SIZE, PesticideResource.ALL));
		request.setAttribute("batchList", 	resourceService.queryByType(PesticideResourceType.BATCH, PesticideResource.ALL));
		request.setAttribute("producerList",resourceService.queryByType(PesticideResourceType.PRODUCER, PesticideResource.ALL));
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
		
		searcher.setTable("t_pesticide_stock");
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
		return "pesticide/stock/pesticideStockList";
	}

}
