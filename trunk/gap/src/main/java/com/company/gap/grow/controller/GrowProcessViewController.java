package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.component.TranslatorWithCell;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.model.Register;

@Controller
@RequestMapping("grow/process")
public class GrowProcessViewController extends BeanViewController<Register> {

	@Autowired
	private ICellService cellService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		super.preparing(request, model);
		request.setAttribute("cellList", cellService.findList());
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("growstatus", Op.IN, "0;1");
	}
	
	@Autowired
	public void needTranslatorCell(TranslatorWithCell translator) {
		registerTranslator("cellId", translator);
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		
		for (Register register : datas) {
			Dto disp = register.getDisp();
			disp.put("regdate", 	DateUtils.format(register.getRegdate()));
			disp.put("status", 		Status.valueOf(register.getStatus()).getName());
			disp.put("growstatus", 	GrowStatus.valueOf(register.getGrowstatus()).getName());
		}
	}


	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/process/growProcessList";
	}
}