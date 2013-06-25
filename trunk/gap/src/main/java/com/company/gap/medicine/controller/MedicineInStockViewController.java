package com.company.gap.medicine.controller;

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
import com.company.gap.medicine.component.MedicineResourceHelper;
import com.company.gap.medicine.enumeration.MedicineResourceType;
import com.company.gap.medicine.model.InStock;
import com.company.gap.medicine.model.Resource;

@Controller
@RequestMapping("admin/medicine/instock")
public class MedicineInStockViewController extends BeanViewController<InStock> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	MedicineResourceHelper.getList(MedicineResourceType.PM, Resource.RS_ALL));
		request.setAttribute("specList", 	MedicineResourceHelper.getList(MedicineResourceType.GG,  Resource.RS_ALL));
		request.setAttribute("batchList", 	MedicineResourceHelper.getList(MedicineResourceType.SCPH,  Resource.RS_ALL));
		request.setAttribute("producerList",MedicineResourceHelper.getList(MedicineResourceType.SCS,  Resource.RS_ALL));
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
			disp.put("nameId", 		MedicineResourceHelper.getText(inStock.getNameId()));
			disp.put("specId", 		MedicineResourceHelper.getText(inStock.getSpecId()));
			disp.put("batchId", 	MedicineResourceHelper.getText(inStock.getBatchId()));
			disp.put("producerId", 	MedicineResourceHelper.getText(inStock.getProducerId()));
			disp.put("indate", 		DateUtils.format(inStock.getIndate()));
			disp.put("status", 		Status.valueOf(inStock.getStatus()).getName());
			disp.put("inuserId", 	"XXX");
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/medicine/instock/medicineInStockList";
	}
}