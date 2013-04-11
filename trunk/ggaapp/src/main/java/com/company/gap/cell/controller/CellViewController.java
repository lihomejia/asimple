package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.entity.Cell;
import com.company.gap.cell.enumeration.CellStatus;

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
			CellStatus status = CellStatus.valueOf(cell.getUseStatus());
			cell.get__disp().put("status", status.getName());
			cell.get__disp().put("cdate", DateUtils.format(cell.getBuildDate()));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "cell/list";
	}
}