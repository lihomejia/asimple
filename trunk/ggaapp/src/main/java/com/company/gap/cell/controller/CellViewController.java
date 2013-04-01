package com.company.gap.cell.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.util.DateUtils;
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
		for (Map<String, Object> data : this.datas) {
			CellStatus status = CellStatus.valueOf((Integer) data.get("cell_status"));
			data.put("cell_status__disp", status.getName());
			data.put("cell_cdate", DateUtils.format(data.get("cell_cdate")));
		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "cell/list";
	}
}