package com.company.gap.disinfectant.controller;

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
import com.company.gap.disinfectant.component.DisinfectantResourceHelper;
import com.company.gap.disinfectant.enumeration.DisinfectantResourceType;
import com.company.gap.disinfectant.model.InStock;
import com.company.gap.disinfectant.model.Resource;

@Controller
@RequestMapping("admin/disinfectant/instock")
public class DisinfectantInStockViewController extends BeanViewController<InStock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	DisinfectantResourceHelper.getList(DisinfectantResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",DisinfectantResourceHelper.getList(DisinfectantResourceType.SCS,  Resource.RS_ALL));
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
			disp.put("nameId", 		DisinfectantResourceHelper.getText(inStock.getNameId()));
			disp.put("specId", 		DisinfectantResourceHelper.getText(inStock.getSpecId()));
			disp.put("batchId", 	DisinfectantResourceHelper.getText(inStock.getBatchId()));
			disp.put("producerId", 	DisinfectantResourceHelper.getText(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/disinfectant/instock/disinfectantInStockList";
	}
}