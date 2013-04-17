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
import com.company.gap.grow.model.Harvest;

@Controller
@RequestMapping("grow/harvest")
public class GrowHarvestViewController extends BeanViewController<Harvest> {
	
	public GrowHarvestViewController() {
		super(Harvest.class);
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String registerId = request.getParameter("registerId");
		request.setAttribute("registerId", registerId);
		searcher.addSf("register_id", Op.EQ, registerId);
		
		
		searcher.setTable("t_grow_harvest");
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Harvest harvest : datas) {
			Dto __disp = harvest.get__disp();
			__disp.put("operatedate", DateUtils.format(harvest.getOperatedate()));
			__disp.put("status", Status.valueOf(harvest.getStatus()).getName());
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/harvest/growHarvestList";
	}


}
