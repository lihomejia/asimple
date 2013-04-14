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
import com.company.gap.grow.model.Farm;

@Controller
@RequestMapping("grow/farm")
public class FarmViewController extends BeanViewController<Farm> {

	public FarmViewController() {
		super(Farm.class);
	}


	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		searcher.addSf("register_id", Op.EQ, registerId);
		
		
		searcher.setTable("t_grow_farm");
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Farm farm : datas) {
			Dto __added = farm.get__added();
			__added.put("activitydate", DateUtils.format(farm.getActivitydate()));
			__added.put("status", Status.valueOf(farm.getStatus()).getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/farm/growFarmList";
	}

	
	

}
