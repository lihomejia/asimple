package com.company.gap.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.GapConstants;
import com.company.gap.base.LocalContext;
import com.company.gap.system.model.User;
import com.company.gap.system.service.IUserService;


@Controller
@RequestMapping("admin/{companyno}")
public class LoginController {
	
	private final static String MESSAGE = "msg";

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBackendCompanyService backendCompanyService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, User user, @PathVariable("companyno") String companyno) {

		String error = "error_user";
		
		String userId = StringUtils.defaultString(user.getUserId());
		User tempUser = new User();
		tempUser.setUserId(userId);
		
		
		Company company = backendCompanyService.findCompanyByCompanyNo(companyno);
		if (company == null || company.getId() == 0) {
			request.setAttribute(MESSAGE, "用户名" + user.getUserId() + "不存在!");
			return error;
		}
		
		/** 此处的companyId并非数据表自增的id*/
		String companyId = String.valueOf(company.getInnercode());
		
		List<User> uList = userService.findList(companyId, tempUser);
		
		if (uList.size() == 0) {
			request.setAttribute(MESSAGE, "用户名" + user.getUserId() + "不存在!");
			return error;
		}
		User u = uList.get(0);
		
		if (!StringUtils.defaultString(u.getPassWord()).equals(user.getPassWord())) {
			request.setAttribute(MESSAGE, "用户名或密码不正确!");
			return error;
		}
		u.setCompanyId(companyId);
		u.setCompanyno(companyno);
		u.setCompanyType(company.getType());
		u.setUserType(2);
		u.setCompanyId(company.getInnercode());
		LocalContext.setUser(u);
		HttpSession session = request.getSession(true);
		session.setAttribute(GapConstants.USER_BEAN, u);
		
		return "redirect:/admin/" + companyno + "/homepage.html";
	}
}
