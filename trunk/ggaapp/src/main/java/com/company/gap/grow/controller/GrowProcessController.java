package com.company.gap.grow.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;

@Controller
@RequestMapping("grow/process")
public class GrowProcessController extends ViewController {
	@Autowired
	private ICellService cellService;

	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		super.preparing(request, model);
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("register_status", Op.IN, "0;1");
		searcher.setTable("t_grow_register");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> cellId2Code = cellService.queryCellId2Code();
		
		for (Map<String, Object> data : datas) {
			int cellId = NumberUtils.toInt(ObjectUtils.toString(data.get("register_cellid")));
			data.put("register_cellid__disp", 	cellId2Code.get(cellId));
			data.put("register_regdate__disp", 	DateUtils.format(data.get("register_regdate")));
			GrowStatus status = GrowStatus.valueOf(NumberUtils.toInt(ObjectUtils.toString(data.get("register_status"))));
			data.put("register_status__disp", 	status.getName());
		}
	}


	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/process/growProcessList";
	}

}
