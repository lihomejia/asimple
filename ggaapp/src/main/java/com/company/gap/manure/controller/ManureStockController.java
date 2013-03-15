package com.company.gap.manure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureStockService;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("manure")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ManureStockController extends ViewController {
	
	@Autowired
	private IManureStockService manureStockService;
	
	@RequestMapping("stockQueryPage")
	@ResponseBody
	public Map<String, Object> stockQueryPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") int page) {
		
		List<ManureStock> list = manureStockService.queryList();
		
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("records", list);
		ret.put("total", 499);
		return ret;
	}
	
	@Override
	protected void dowithSearcher() {
		super.dowithSearcher();
		
		SimpleSearcher ss = (SimpleSearcher) searcher;
		
		ss.addSf2("mastock_Id", Op.BT, "1000");
		ss.addSf2("mastock_Id", Op.LE, "10000");
		ss.addSf("mastock_Balqty", Op.EQ, "15");
		ss.addSf("mastock_Note", Op.CONTAINS, "2d");
		
		ss.addOrder("mastock_Id");
		ss.addGroup("mastock_Id,mastock_Totqty, mastock_Usedqty, mastock_Balqty, mastock_Note");
		ss.setTable("ma_stock");
		
		
	}

	@Override
	protected String rootRequestMapping() {
		return "manure/stock";
	}
}