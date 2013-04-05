package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.entity.TCell;
import com.company.gap.cell.enumeration.CellStatus;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("cell")
public class CellViewController extends ViewController {
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.setTable("t_production_cell");
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
		for (Dto dto : this.datas) {
			CellStatus status = CellStatus.valueOf(dto.getInt(TCell.STATUS));
			dto.put(TCell.STATUS + __DISP, status.getName());
			dto.put(TCell.CDATE, DateUtils.format(dto.getDate(TCell.CDATE)));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "cell/list";
	}
}