package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.tab.TFarm;
import com.company.gap.grow.tab.THarvest;
import com.company.gap.grow.tab.TRegister;

@Controller
@RequestMapping("grow/farm")
public class GrowFarmViewController extends ViewController {

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String register_id = request.getParameter(TRegister.ID);
		request.setAttribute(TRegister.ID, register_id);
		searcher.addSf(THarvest.REGISTERID, Op.EQ, register_id);
		
		
		searcher.setTable("t_grow_farm");
	}
	

	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Dto dto : datas) {
			dto.put(TFarm.DATE + __DISP, DateUtils.format(dto.getDate(TFarm.DATE)));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/farm/growFarmList";
	}

	
	

}
