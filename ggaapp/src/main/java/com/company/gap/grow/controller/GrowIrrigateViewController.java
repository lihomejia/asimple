package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.Status;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.model.Irrigate;

@Controller
@RequestMapping("grow/irrigate")
public class GrowIrrigateViewController extends BeanViewController<Irrigate> {

	public GrowIrrigateViewController() {
		super(Irrigate.class);
	}


	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		searcher.addSf("register_id", Op.EQ, registerId);
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Irrigate  irrigate : datas) {
			Dto __disp = irrigate.get__disp();
			__disp.put("date", DateUtils.format(irrigate.getDate()));
			__disp.put("status", Status.valueOf(irrigate.getStatus()).getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/irrigate/growIrrigateList";
	}
}