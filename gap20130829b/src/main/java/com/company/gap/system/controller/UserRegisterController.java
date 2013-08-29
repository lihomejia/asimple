package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.system.model.User;
import com.company.gap.system.service.IUserService;

@Controller
@RequestMapping("admin")
public class UserRegisterController {
	
	@Autowired
	private IUserService userService;

	
	@RequestMapping("register")
	public String register() {
		return "admin/register";
	}
	
	@RequestMapping("registersave")
	public String registersave(HttpServletRequest request, User user) {
		
		userService.save(user);
		
		return "redirect:/web/index.html";
	}
	
}
