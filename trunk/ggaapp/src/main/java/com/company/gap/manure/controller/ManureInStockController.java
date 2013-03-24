package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.manure.entity.ManureInStock;
import com.company.gap.manure.entity.ManureResource;
import com.company.gap.manure.enumeration.ManureInStockStatus;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureInStockService;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/instock")
public class ManureInStockController extends ViewController {

	@Autowired
	private IManureResourceService resourceService;
	@Autowired
	private IManureInStockService inStockService;
	
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
		for (Map<String, Object> data : datas) {
			data.put("instock_nameid__disp", 	resId2Res.get((Integer) data.get("instock_nameid")));
			data.put("instock_sizeid__disp", 	resId2Res.get((Integer) data.get("instock_sizeid")));
			data.put("instock_batchid__disp", 	resId2Res.get((Integer) data.get("instock_batchid")));
			data.put("instock_producerid__disp",resId2Res.get((Integer) data.get("instock_producerid")));
			data.put("instock_indate__disp", 	DateUtils.format(data.get("instock_indate")));
			ManureInStockStatus status = ManureInStockStatus.valueOf((Integer) data.get("instock_status"));
			data.put("instock_status__disp", 	status.getName());
		}
	}
	
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
		request.setAttribute("nameList", 	resourceService.queryByType(ManureResourceType.NAME));
		request.setAttribute("sizeList", 	resourceService.queryByType(ManureResourceType.SIZE));
		request.setAttribute("batchList", 	resourceService.queryByType(ManureResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(ManureResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(ManureResourceType.KIND));
		return "manure/instock/manureInStoctEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, ManureInStock inStock) {
		inStockService.save(inStock);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		return "redirect:/manure/instock/list.html";
	}
	
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.auditing(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.delete(instock_id);
		return "redirect:/manure/instock/list.html";
	}
	
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "manure/instock/manureInStockList";
	}
}