package com.norming.ess.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.base.Constants;


@Controller
@RequestMapping(value="/framework/logout")
public class LogoutController {
	
	@RequestMapping
	public String index(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(Constants.USER_BEAN);
			session.invalidate();
			
		} catch (Throwable t) {}
		
		return "redirect:/framework/login";
	}

}
