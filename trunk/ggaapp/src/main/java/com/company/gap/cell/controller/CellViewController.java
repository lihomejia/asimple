package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.Status;
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
			cell.get__disp().put("status", Status.valueOf(cell.getStatus()).getName());
			cell.get__disp().put("usestatus", CellStatus.valueOf(cell.getUsestatus()).getName());
			cell.get__disp().put("builddate", DateUtils.format(cell.getBuilddate()));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "cell/list";
	}
}