package com.company.gap.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.LocalContext;
import com.company.gap.system.model.User;
import com.company.gap.web.service.IGrowProductQueryService;
import com.company.gap.web.service.INutureProductQueryService;
import com.company.gap.web.service.IProductQueryService;

@Controller
@RequestMapping("product/query")
public class ProductQueryController {
	
	@Autowired
	private IGrowProductQueryService growProductQueryService;
	
	@Autowired
	private INutureProductQueryService nutureProductQueryService;
	
	@RequestMapping("doHtml5")
	public String doHtml5(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = StringUtils.defaultString(request.getParameter("id"));
		//A001G0
		if (id.length() < 6) {
			return "result";
		}
		
		String companyId = id.substring(0,  4);
		User user = new User();
		user.setCompanyId(companyId);
		LocalContext.setUser(user);
		String type = String.valueOf(id.charAt(4));
		int key = NumberUtils.toInt(id.substring(5));
		
		IProductQueryService productQueryService = null;
		if ("G".equals(type)) {
			productQueryService = growProductQueryService;
		} else if ("N".equals(type)) {
			productQueryService = nutureProductQueryService;
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		if (productQueryService != null) {
			request.setAttribute("content", productQueryService.query(key));
		}
		return "result";
	}
	
	
}
