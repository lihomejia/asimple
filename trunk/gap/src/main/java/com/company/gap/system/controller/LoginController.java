package com.company.gap.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.system.model.User;
import com.company.gap.system.service.impl.ServiceContext;


@Controller
@RequestMapping("admin")
public class LoginController {

	
	@RequestMapping("login")
	public String login(User user) {
		
		if (!"admin".equals(user.getPassWord())) {
			return "redirect:/web/index.html";
		}
		
		ServiceContext.setUser(user);
		
		return "redirect:/admin/homepage.html";
	}
}
