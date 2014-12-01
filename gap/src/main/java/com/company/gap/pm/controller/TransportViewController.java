package com.company.gap.pm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.component.TranslatorWithDate;
import com.company.gap.base.component.TranslatorWithStatus;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.pm.model.Transport;
import com.company.gap.resource.component.DictHelper;


@Controller
@RequestMapping("admin/pm/transport")
public class TransportViewController extends BeanViewController<Transport> {
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
	}

	
	protected void registTranslators() {
		registerTranslator("status", 	TranslatorWithStatus.getInstance());
		registerTranslator("transportdate", TranslatorWithDate.getInstance());
	}

	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Transport transport : datas) {
			Dto disp = transport.getDisp();
			disp.put("productId", DictHelper.getText(transport.getProductId()));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request,
			ViewFormModel model) {
		return "admin/pm/transport/list";
	}

}
