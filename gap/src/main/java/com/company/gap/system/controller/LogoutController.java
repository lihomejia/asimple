package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.GapConstants;


@Controller
@RequestMapping("admin/{companyno}")
public class LogoutController {

	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, @PathVariable("companyno") String companyno) {
		
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(GapConstants.USER_BEAN);
			session.invalidate();
			
		} catch (Throwable t) {}
		
		return "redirect:/company/" + companyno + ".html";
	}
}
