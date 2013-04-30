package com.company.gap.grow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.AbstractElement;
import com.company.gap.Attribute;
import com.company.gap.SimpleElement;

@Controller
@RequestMapping("product")
public class ProductQueryController {
	
	@RequestMapping("query")
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String productId = request.getParameter("productId");
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		
		
		AbstractElement root = new AbstractElement("result");
		
		AbstractElement base = new AbstractElement("基本信息");
		
		
		base.addChild(new SimpleElement("产品编号", "笑嘻嘻"));
		
		root.addChild(base);
		
		base.addAttribute(new Attribute("abc", "123"));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		root.writerXml(sb);
		
		response.getWriter().append(sb).flush();
		
		
	}
}
