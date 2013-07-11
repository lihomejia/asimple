package com.norming.ess.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.base.Constants;
import com.norming.ess.framework.service.impl.ServiceContext;
import com.norming.ess.user1.model.User;


@Controller
@RequestMapping(value="/framework/login")
public class LoginController {
	
	@RequestMapping
	public String index() {
		return "framework/login/index";
	}

	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request) {

		boolean valid = true;
		//TODO
		
		if (!valid) {
			return index();
		}
		
		HttpSession session = request.getSession(true);
		
		User user = new User();
		
		ServiceContext.setUser(user);
		
		session.setAttribute(Constants.USER_BEAN, user);
		
		return "redirect:/framework/homepage";
	}
	
}
