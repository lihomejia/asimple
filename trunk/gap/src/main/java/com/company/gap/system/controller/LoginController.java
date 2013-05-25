package com.company.gap.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.GapConstants;
import com.company.gap.system.model.User;
import com.company.gap.system.service.ILoginService;
import com.company.gap.system.service.impl.ServiceContext;


@Controller
@RequestMapping("admin")
public class LoginController {

	@Autowired
	private ILoginService service;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, User user) {
		
		User tempUser = new User();
		tempUser.setUserName(user.getUserName());
		
		List<User> uList = service.findList(tempUser);
		
		String redirect = "redirect:/web/index.html";
		
		if (uList.size() == 0) {
			//not exists
			return redirect;
		}
		User u = uList.get(0);
		
		
		if (!StringUtils.defaultString(u.getPassWord()).equals(user.getPassWord())) {
			//
			return redirect;
		}
		
		
		ServiceContext.setUser(u);
		HttpSession session = request.getSession(true);
		session.setAttribute(GapConstants.USER_BEAN, u);
		
		return "redirect:/admin/homepage.html";
	}
}
