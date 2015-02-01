package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.system.model.User;
import com.company.gap.system.service.IUserService;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("admin/user")
public class UserEntryController extends BeanEntryController<User> {
	
	@Autowired
	private IUserService service;
	
	@Override
	protected IBaseService<User> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/user/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/user/entry";
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, User t) {
		super.initializeEdit(request, t);
	}
}