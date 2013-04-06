package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.tab.TIrrigate;
import com.company.gap.grow.tab.TRegister;

@Controller
@RequestMapping("grow/irrigate")
public class GrowIrrigateViewController extends ViewController {

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String register_id = request.getParameter(TRegister.ID);
		request.setAttribute(TRegister.ID, register_id);
		searcher.addSf(TIrrigate.REGISTERID, Op.EQ, register_id);
		
		searcher.setTable("t_grow_irrigate");
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Dto dto : datas) {
			dto.put(TIrrigate.DATE + __DISP, DateUtils.format(dto.getDate(TIrrigate.DATE)));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/irrigate/growIrrigateList";
	}
}