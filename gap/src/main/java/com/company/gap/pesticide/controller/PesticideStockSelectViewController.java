package com.company.gap.pesticide.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.pesticide.enumeration.ResourceType;
import com.company.gap.pesticide.model.Stock;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/stock/select")
public class PesticideStockSelectViewController extends BeanViewController<Stock> {
	
	@Autowired
	private IPesticideResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ResourceType.NAME, true));
		request.setAttribute("specList", 	resourceService.queryByType(ResourceType.SPEC, true));
		request.setAttribute("batchList", 	resourceService.queryByType(ResourceType.BATCH, true));
		request.setAttribute("producerList",resourceService.queryByType(ResourceType.PRODUCER, true));
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
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Stock stock : datas) {
			Dto disp = stock.getDisp();
			disp.put("nameId", 		resId2Res.get(stock.getNameId()));
			disp.put("specId", 		resId2Res.get(stock.getSpecId()));
			disp.put("batchId", 	resId2Res.get(stock.getBatchId()));
			disp.put("producerId",	resId2Res.get(stock.getProducerId()));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "pesticide/stock/pesticideStockSelectList";
	}
}