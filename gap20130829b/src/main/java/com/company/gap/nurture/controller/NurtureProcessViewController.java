package com.company.gap.nurture.controller;

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
import com.company.gap.nurture.enumeration.NurtureStatus;
import com.company.gap.nurture.model.Register;

@Controller
@RequestMapping("admin/nurture/process")
public class NurtureProcessViewController extends BeanViewController<Register> {

	@Autowired
	private ICellService cellService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		super.preparing(request, model);
		request.setAttribute("cellList", cellService.findList());
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("nurturestatus", Op.IN, "0;1");
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
			disp.put("nurturestatus", 	NurtureStatus.valueOf(register.getNurturestatus()).getName());
		}
	}


	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/nurture/process/nurtureProcessList";
	}
}