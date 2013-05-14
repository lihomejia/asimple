package com.company.gap.system.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("admin")
public class LoginController {

	
	@RequestMapping("login")
	public String login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
		
		if (!"admin".equals(passWord)) {
			return "redirect:/web/index.html";
		}
		
		
		
		return "redirect:/admin/homepage.html";
	}
}
