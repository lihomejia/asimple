package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.system.model.User;
import com.company.gap.system.service.impl.ServiceContext;


@Controller
@RequestMapping("admin")
public class TabController {
	
	@RequestMapping("/tab")
	public String homepage(HttpServletRequest request) {
		
		User user = ServiceContext.getUser();
		
		request.setAttribute("user", user);
		
		return "admin/tab";
		
	}
	
}
