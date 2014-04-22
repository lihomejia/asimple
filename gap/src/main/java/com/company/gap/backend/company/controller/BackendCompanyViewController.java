package com.company.gap.backend.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.backend.company.model.Company;
import com.company.gap.base.component.TranslatorWithStatus;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;

@Controller
@RequestMapping("backend/company")
public class BackendCompanyViewController extends BeanViewController<Company> {
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
	}
	
	protected void registTranslators() {
		registerTranslator("status", 	TranslatorWithStatus.getInstance());
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "backend/company/list";
	}
}