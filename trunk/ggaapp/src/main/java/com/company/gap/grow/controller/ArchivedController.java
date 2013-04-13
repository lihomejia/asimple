package com.company.gap.grow.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;

@Controller
@RequestMapping("grow/archived")
public class ArchivedController extends ViewController {

	@Autowired
	private ICellService cellService;
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		super.preparing(request, model);
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("register_status", Op.EQ, String.valueOf(GrowStatus.ARCHIVED.getStatus()));
		
		searcher.setTable("t_grow_register");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> cellId2Code = cellService.queryId2Code();
		
		for (Dto dto : datas) {
			dto.put("register_cellid__disp", 	cellId2Code.get(dto.getInt("register_cellid")));
			dto.put("register_regdate__disp", 	DateUtils.format(dto.getDate("register_regdate")));
			GrowStatus status = GrowStatus.valueOf(dto.getInt("register_status"));
			dto.put("register_status__disp", 	status.getName());
		}
	}


	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/archived/growArchivedList";
	}

}
