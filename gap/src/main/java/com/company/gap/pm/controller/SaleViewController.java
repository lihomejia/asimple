package com.company.gap.pm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.component.TranslatorWithDate;
import com.company.gap.base.component.TranslatorWithStatus;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.pm.model.Sale;


@Controller
@RequestMapping("admin/pm/sale")
public class SaleViewController extends BeanViewController<Sale> {
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
	}
	

	
	protected void registTranslators() {
		registerTranslator("status", 	TranslatorWithStatus.getInstance());
		registerTranslator("saledate", TranslatorWithDate.getInstance());
	}

	@Override
	protected String viewResolver(HttpServletRequest request,
			ViewFormModel model) {
		return "admin/pm/sale/list";
	}

}
