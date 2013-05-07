package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.model.InStock;
import com.company.gap.manure.model.Resource;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockViewController extends BeanViewController<InStock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	ManureResourceHelper.getList(ManureResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	ManureResourceHelper.getList(ManureResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	ManureResourceHelper.getList(ManureResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",ManureResourceHelper.getList(ManureResourceType.SCS,  Resource.RS_ALL));
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
		for (InStock inStock : datas) {
			Dto disp = inStock.getDisp();
			disp.put("nameId", 		ManureResourceHelper.getText(inStock.getNameId()));
			disp.put("specId", 		ManureResourceHelper.getText(inStock.getSpecId()));
			disp.put("batchId", 	ManureResourceHelper.getText(inStock.getBatchId()));
			disp.put("producerId", 	ManureResourceHelper.getText(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}