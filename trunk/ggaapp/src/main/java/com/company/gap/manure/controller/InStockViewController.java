package com.company.gap.manure.controller;

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
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.service.IResourceService;

@Controller
@RequestMapping("manure/instock")
public class InStockViewController extends BeanViewController<InStock> {

	@Autowired
	private IResourceService resourceService;
	
	public InStockViewController() {
		super(InStock.class);
	}
	
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
			searcher.addSf("stock_id", Op.EQ, stockId);
		}
		
		searcher.setTable("t_manure_instock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (InStock inStock : datas) {
			Dto __added = inStock.get__added();
			__added.put("nameId", 		resId2Res.get(inStock.getNameId()));
			__added.put("specId", 		resId2Res.get(inStock.getSpecId()));
			__added.put("batchId", 		resId2Res.get(inStock.getBatchId()));
			__added.put("producerId", 	resId2Res.get(inStock.getProducerId()));
			__added.put("indate", 		DateUtils.format(inStock.getIndate()));
			__added.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			__added.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}