package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
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
import com.company.gap.manure.model.OutStock;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/outstock")
public class ManureOutStockViewController extends BeanViewController<OutStock> {
	
	public ManureOutStockViewController() {
		super(OutStock.class);
	}
	
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
		String stockId = StringUtils.defaultString(request.getParameter("stockId"));
		String register_id = StringUtils.defaultString(request.getParameter("register_id"));
		if (StringUtils.isNotEmpty(stockId)) {
			request.setAttribute("stockId", stockId);
			searcher.addSf("outstock_stockid", Op.EQ, stockId);
		}
		if (StringUtils.isNotEmpty(register_id)) {
			request.setAttribute("register_id", register_id);
			searcher.addSf("outstock_registerid", Op.EQ, register_id);
		}
		
		Map<String, Object> data = model.getData();
		String nameid 		= ObjectUtils.toString(data.get("nameid"), "0");
		String sizeid 		= ObjectUtils.toString(data.get("sizeid"), "0");
		String batchid 		= ObjectUtils.toString(data.get("batchid"), "0");
		String producerid 	= ObjectUtils.toString(data.get("producerid"), "0");
		if (!"0".equals(nameid)) 	searcher.addSf("outstock_nameid", Op.EQ, nameid);
		if (!"0".equals(sizeid)) 	searcher.addSf("outstock_sizeid", Op.EQ, sizeid);
		if (!"0".equals(batchid)) 	searcher.addSf("outstock_batchid", Op.EQ, batchid);
		if (!"0".equals(producerid))searcher.addSf("outstock_producerid", Op.EQ, producerid);
		
		searcher.setTable("t_manure_outstock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (OutStock outStock : datas) {
			Dto __adde = outStock.get__added();
			__adde.put("nameId", 		resId2Res.get(outStock.getNameId()));
			__adde.put("specId", 		resId2Res.get(outStock.getSpecId()));
			__adde.put("batchId", 		resId2Res.get(outStock.getBatchId()));
			__adde.put("producerId", 	resId2Res.get(outStock.getProducerId()));
			__adde.put("outdate", 		DateUtils.format(outStock.getOutdate()));
			Status status = Status.valueOf(outStock.getStatus());
			__adde.put("status", 		status.getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/outstock/manureOutStockList";
	}
}
