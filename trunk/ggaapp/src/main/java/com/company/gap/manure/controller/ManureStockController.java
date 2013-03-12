package com.company.gap.manure.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureStockService;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 * 库存
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("manure")
public class ManureStockController {
	
	@Autowired
	private IManureStockService manureStockService;
	
	@RequestMapping("stockList")
	public String stockListInit() {
		return "manure/stockList";
	}
	
	@RequestMapping("stockQueryPage")
	public @ResponseBody Map<String, Object> stockQueryPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") int page) {
		
		List<ManureStock> list = manureStockService.queryList();
		
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("records", list);
		ret.put("total", 499);
		return ret;
	}

}
