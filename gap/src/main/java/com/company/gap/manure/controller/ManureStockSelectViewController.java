package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.model.Resource;
import com.company.gap.manure.model.Stock;

@Controller
@RequestMapping("manure/stock/select")
public class ManureStockSelectViewController extends BeanViewController<Stock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	ManureResourceHelper.getList(ManureResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	ManureResourceHelper.getList(ManureResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	ManureResourceHelper.getList(ManureResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",ManureResourceHelper.getList(ManureResourceType.SCS,  Resource.RS_ALL));
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
			disp.put("nameId", 		ManureResourceHelper.getText(t.getNameId()));
			disp.put("specId", 		ManureResourceHelper.getText(t.getSpecId()));
			disp.put("batchId", 	ManureResourceHelper.getText(t.getBatchId()));
			disp.put("producerId", 	ManureResourceHelper.getText(t.getProducerId()));
		}
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/stock/manureStockSelectList";
	}
}