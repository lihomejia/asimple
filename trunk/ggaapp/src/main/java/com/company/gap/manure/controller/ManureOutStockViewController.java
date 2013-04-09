package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ManureOutStockStatus;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/outstock")
public class ManureOutStockViewController extends ViewController {
	
	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ManureResourceType.NAME, true));
		request.setAttribute("sizeList", 	resourceService.queryByType(ManureResourceType.SIZE, true));
		request.setAttribute("batchList", 	resourceService.queryByType(ManureResourceType.BATCH, true));
		request.setAttribute("producerList",resourceService.queryByType(ManureResourceType.PRODUCER, true));
		
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String stock_id = StringUtils.defaultString(request.getParameter("stock_id"));
		String register_id = StringUtils.defaultString(request.getParameter("register_id"));
		if (StringUtils.isNotEmpty(stock_id)) {
			request.setAttribute("stock_id", stock_id);
			searcher.addSf("outstock_stockid", Op.EQ, stock_id);
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
		for (Dto dto : datas) {
			dto.put("outstock_nameid__disp", 	resId2Res.get(dto.getInt("outstock_nameid")));
			dto.put("outstock_sizeid__disp", 	resId2Res.get(dto.getInt("outstock_sizeid")));
			dto.put("outstock_batchid__disp", 	resId2Res.get(dto.getInt("outstock_batchid")));
			dto.put("outstock_producerid__disp",resId2Res.get(dto.getInt("outstock_producerid")));
			dto.put("outstock_outdate__disp", 	DateUtils.format(dto.getDate("outstock_outdate")));
			ManureOutStockStatus status = ManureOutStockStatus.valueOf(dto.getInt("outstock_status"));
			dto.put("outstock_status__disp", 	status.getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/outstock/manureOutStockList";
	}
}
