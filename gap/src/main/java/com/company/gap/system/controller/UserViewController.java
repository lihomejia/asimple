package com.company.gap.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.system.model.User;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("admin/user")
public class UserViewController extends BeanViewController<User> {
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
	}
	
	protected void registTranslators() {
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/user/list";
	}
}