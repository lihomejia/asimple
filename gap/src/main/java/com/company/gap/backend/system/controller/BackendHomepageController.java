package com.company.gap.backend.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.LocalContext;
import com.company.gap.system.model.User;


@Controller
@RequestMapping("backend")
public class BackendHomepageController {
	
	@RequestMapping("/homepage")
	public String homepage(HttpServletRequest request) {
		
		User user = LocalContext.getUser();
		
		request.setAttribute("user", user);
		
		return "backend/homepage";
		
	}
	
}
