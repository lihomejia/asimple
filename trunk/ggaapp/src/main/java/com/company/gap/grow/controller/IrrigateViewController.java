package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.model.Irrigate;

@Controller
@RequestMapping("grow/irrigate")
public class IrrigateViewController extends BeanViewController<Irrigate> {

	public IrrigateViewController() {
		super(Irrigate.class);
	}


	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		searcher.addSf("registerId", Op.EQ, registerId);
		searcher.setTable("t_grow_irrigate");
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Irrigate  irrigate : datas) {
			Dto __added = irrigate.get__added();
			__added.put("date", DateUtils.format(irrigate.getDate()));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/irrigate/growIrrigateList";
	}
}