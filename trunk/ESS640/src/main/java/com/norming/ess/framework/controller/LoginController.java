package com.norming.ess.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.norming.ess.base.Constants;
import com.norming.ess.base.SpringContextHolder;
import com.norming.ess.framework.service.impl.ServiceContext;
import com.norming.ess.user1.model.User;
import com.norming.ess.user1.service.IUserService;


@Controller
@RequestMapping(value="/framework/login")
public class LoginController {
	
	@RequestMapping
	public String index() {
		return "framework/login/index";
	}

	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request, 
			@RequestParam("asuserUserid") String asuserUserid,
			@RequestParam("asuserPwd") String asuserPwd) {

		IUserService userService = SpringContextHolder.getBean(IUserService.class);
		//IUserService userService = SpringContextHolder.getBean("userService");
		
		User user = userService.findUserById(asuserUserid);
		if (user == null || !asuserPwd.equals(user.getAsuserPwd())) {
			return index();
		}
		
		HttpSession session = request.getSession(true);
		
		ServiceContext.setUser(user);
		
		session.setAttribute(Constants.USER_BEAN, user);
		
		return "redirect:/framework/homepage";
	}
}
