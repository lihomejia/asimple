package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.GapConstants;
import com.company.gap.system.model.User;
import com.company.gap.system.service.impl.ServiceContext;


@Controller
@RequestMapping("admin")
public class LoginController {

	
	@RequestMapping("login")
	public String login(HttpServletRequest request, User user) {
		
		if (!"admin".equals(user.getPassWord())) {
			return "redirect:/web/index.html";
		}
		
		ServiceContext.setUser(user);
		HttpSession session = request.getSession(true);
		session.setAttribute(GapConstants.USER_BEAN, user);
		
		return "redirect:/admin/homepage.html";
	}
}
