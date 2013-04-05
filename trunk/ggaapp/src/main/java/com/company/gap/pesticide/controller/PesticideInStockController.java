package com.company.gap.pesticide.controller;

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
import com.company.gap.base.util.Dto;
import com.company.gap.pesticide.entity.PesticideInStock;
import com.company.gap.pesticide.entity.PesticideResource;
import com.company.gap.pesticide.enumeration.PesticideInStockStatus;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.service.IPesticideInStockService;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/instock")
public class PesticideInStockController extends ViewController {

	@Autowired
	private IPesticideResourceService resourceService;
	@Autowired
	private IPesticideInStockService inStockService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("nameList", 	resourceService.queryByType(PesticideResourceType.NAME, PesticideResource.ALL));
		request.setAttribute("sizeList", 	resourceService.queryByType(PesticideResourceType.SIZE, PesticideResource.ALL));
		request.setAttribute("batchList", 	resourceService.queryByType(PesticideResourceType.BATCH, PesticideResource.ALL));
		request.setAttribute("producerList",resourceService.queryByType(PesticideResourceType.PRODUCER, PesticideResource.ALL));
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
		
		searcher.setTable("t_pesticide_instock");
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
			PesticideInStockStatus status = PesticideInStockStatus.valueOf(dto.getInt("instock_status"));
			dto.put("instock_status__disp", 	status.getName());
		}
	}
	
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
		_action = ACT_ADD;
		this.initData(request);
		request.setAttribute("inStock", new PesticideInStock());
		return "pesticide/instock/pesticideInStoctEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, PesticideInStock inStock) {
		inStockService.save(inStock);
		return "redirect:/pesticide/instock/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		_action = ACT_EDIT;
		this.initData(request);
		PesticideInStock inStock = inStockService.findInStockById(instock_id);
		request.setAttribute("inStock", inStock);
		return "Pesticide/instock/PesticideInStoctEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		_action = ACT_DISP;
		this.initData(request);
		PesticideInStock inStock = inStockService.findInStockById(instock_id);
		request.setAttribute("inStock", inStock);
		return "pesticide/instock/pesticideInStoctEntry";
	}
	
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.auditing(instock_id);
		return "redirect:/pesticide/instock/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.nullify(instock_id);
		return "redirect:/pesticide/instock/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("instock_id") int instock_id) {
		inStockService.delete(instock_id);
		return "redirect:/pesticide/instock/list.html";
	}
	
	private void initData(HttpServletRequest request) {
		request.setAttribute(ACT_NAME, 		_action);
		request.setAttribute("nameList", 	resourceService.queryByType(PesticideResourceType.NAME));
		request.setAttribute("sizeList", 	resourceService.queryByType(PesticideResourceType.SIZE));
		request.setAttribute("batchList", 	resourceService.queryByType(PesticideResourceType.BATCH));
		request.setAttribute("producerList",resourceService.queryByType(PesticideResourceType.PRODUCER));
		request.setAttribute("kindList", 	resourceService.queryByType(PesticideResourceType.KIND));
	}
	
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "pesticide/instock/pesticideInStockList";
	}
}