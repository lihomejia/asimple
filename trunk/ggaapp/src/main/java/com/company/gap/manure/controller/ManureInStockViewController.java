package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.entity.ManureResource;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockViewController extends ViewController {

	@Autowired
	private IManureResourceService resourceService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(ManureResourceType.NAME, ManureResource.ALL));
		request.setAttribute("sizeList", 	resourceService.queryByType(ManureResourceType.SIZE, ManureResource.ALL));
		request.setAttribute("batchList", 	resourceService.queryByType(ManureResourceType.BATCH, ManureResource.ALL));
		request.setAttribute("producerList",resourceService.queryByType(ManureResourceType.PRODUCER, ManureResource.ALL));
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		int stock_id = NumberUtils.toInt(request.getParameter("stock_id"));
		if (stock_id != 0) {
			request.setAttribute("stock_id", stock_id);
			searcher.addSf("instock_stockid", Op.EQ, String.valueOf(stock_id));
		}
		
		Map<String, Object> data = model.getData();
		String nameid 		= ObjectUtils.toString(data.get("nameid"), "0");
		String sizeid 		= ObjectUtils.toString(data.get("sizeid"), "0");
		String batchid 		= ObjectUtils.toString(data.get("batchid"), "0");
		String producerid 	= ObjectUtils.toString(data.get("producerid"), "0");
		if (!"0".equals(nameid)) 	searcher.addSf("instock_nameid", Op.EQ, nameid);
		if (!"0".equals(sizeid)) 	searcher.addSf("instock_sizeid", Op.EQ, sizeid);
		if (!"0".equals(batchid)) 	searcher.addSf("instock_batchid", Op.EQ, batchid);
		if (!"0".equals(producerid))searcher.addSf("instock_producerid", Op.EQ, producerid);
		
		searcher.setTable("t_manure_instock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Dto dto : datas) {
			dto.put("instock_nameid__disp", 	resId2Res.get(dto.getInt("instock_nameid")));
			dto.put("instock_sizeid__disp", 	resId2Res.get(dto.getInt("instock_sizeid")));
			dto.put("instock_batchid__disp", 	resId2Res.get(dto.getInt("instock_batchid")));
			dto.put("instock_producerid__disp",resId2Res.get(dto.getInt("instock_producerid")));
			dto.put("instock_indate__disp", 	DateUtils.format(dto.getDate("instock_indate")));
			ManureInStockStatus status = ManureInStockStatus.valueOf(dto.getInt("instock_status"));
			dto.put("instock_status__disp", 	status.getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}