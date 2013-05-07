package com.company.gap.pesticide.controller;

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
import com.company.gap.pesticide.component.PesticideResourceHelper;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.model.InStock;
import com.company.gap.pesticide.model.Resource;

@Controller
@RequestMapping("pesticide/instock")
public class PesticideInStockViewController extends BeanViewController<InStock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	PesticideResourceHelper.getList(PesticideResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	PesticideResourceHelper.getList(PesticideResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	PesticideResourceHelper.getList(PesticideResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",PesticideResourceHelper.getList(PesticideResourceType.SCS,  Resource.RS_ALL));
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
			disp.put("nameId", 		PesticideResourceHelper.getText(inStock.getNameId()));
			disp.put("specId", 		PesticideResourceHelper.getText(inStock.getSpecId()));
			disp.put("batchId", 	PesticideResourceHelper.getText(inStock.getBatchId()));
			disp.put("producerId", 	PesticideResourceHelper.getText(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "pesticide/instock/pesticideInStockList";
	}
}