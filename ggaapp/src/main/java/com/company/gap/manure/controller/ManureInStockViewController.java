package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.tab.TInStock;
import com.company.gap.manure.tab.TStock;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockViewController extends ViewController {

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
		int stock_id = NumberUtils.toInt(request.getParameter(TStock.ID));
		if (stock_id != 0) {
			request.setAttribute(TStock.ID, stock_id);
			searcher.addSf(TInStock.STOCKID, Op.EQ, String.valueOf(stock_id));
		}
		
		Dto data = model.getData();
		String nameid 		= data.getString("nameid");
		String sizeid 		= data.getString("sizeid");
		String batchid 		= data.getString("batchid");
		String producerid 	= data.getString("producerid");
		if (!"0".equals(nameid)) 	searcher.addSf(TInStock.NAMEID, Op.EQ, nameid);
		if (!"0".equals(sizeid)) 	searcher.addSf(TInStock.SIZEID, Op.EQ, sizeid);
		if (!"0".equals(batchid)) 	searcher.addSf(TInStock.BATCHID, Op.EQ, batchid);
		if (!"0".equals(producerid))searcher.addSf(TInStock.PRODUCERID, Op.EQ, producerid);
		
		searcher.setTable("t_manure_instock");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> resId2Res = resourceService.queryResId2Name();
		for (Dto dto : datas) {
			dto.put(TInStock.NAMEID + __DISP, 	resId2Res.get(dto.getInt("instock_nameid")));
			dto.put(TInStock.SIZEID + __DISP, 	resId2Res.get(dto.getInt("instock_sizeid")));
			dto.put(TInStock.BATCHID+ __DISP, 	resId2Res.get(dto.getInt("instock_batchid")));
			dto.put(TInStock.PRODUCERID +__DISP,resId2Res.get(dto.getInt("instock_producerid")));
			dto.put(TInStock.INDATE + __DISP, 	DateUtils.format(dto.getDate("instock_indate")));
			ManureInStockStatus status = ManureInStockStatus.valueOf(dto.getInt("instock_status"));
			dto.put(TInStock.STATUS + __DISP, 	status.getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}