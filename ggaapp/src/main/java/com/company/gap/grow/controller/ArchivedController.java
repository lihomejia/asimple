package com.company.gap.grow.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("grow/archived")
public class ArchivedController extends BeanViewController<Register> {

	@Autowired
	private ICellService cellService;
	
	public ArchivedController() {
		super(Register.class);
	}
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		super.preparing(request, model);
		request.setAttribute("cellList", cellService.findList());
	}
	
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("growstatus", Op.EQ, String.valueOf(GrowStatus.ARCHIVED.getStatus()));
		searcher.setTable("t_grow_register");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		Map<Integer, String> cellId2Code = cellService.queryId2Code();
		
		for (Register register : datas) {
			Dto __added = register.get__added();
			__added.put("cellId", 		cellId2Code.get(register.getCellId()));
			__added.put("regdate", 		DateUtils.format(register.getRegdate()));
			__added.put("status", 		Status.valueOf(register.getStatus()).getName());
			__added.put("growstatus", 	GrowStatus.valueOf(register.getGrowstatus()).getName());
		}
	}


	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "grow/archived/growArchivedList";
	}

}
