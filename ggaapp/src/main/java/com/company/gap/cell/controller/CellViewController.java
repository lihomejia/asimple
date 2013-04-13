package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.model.Cell;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("cell")
public class CellViewController extends BeanViewController<Cell> {
	
	public CellViewController() {
		super(Cell.class);
	}
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.setTable("t_production_cell");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Cell cell : this.datas) {
			CellStatus status = CellStatus.valueOf(cell.getUsestatus());
			cell.get__added().put("usestatus", status.getName());
			cell.get__added().put("builddate", DateUtils.format(cell.getBuilddate()));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "cell/list";
	}
}