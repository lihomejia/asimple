package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.component.AbstractGapTranslator;
import com.company.gap.base.component.TranslatorWithDate;
import com.company.gap.base.component.TranslatorWithStatus;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.model.Cell;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("admin/cell")
public class CellViewController extends BeanViewController<Cell> {
	
	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
	}
	
	protected void registTranslators() {
		registerTranslator("status", 	TranslatorWithStatus.getInstance());
		registerTranslator("builddate", TranslatorWithDate.getInstance());
		registerTranslator("usestatus", new AbstractGapTranslator() {
			@Override
			public String translate(Integer key) {
				return CellStatus.valueOf(key).getName();
			}
		});
	}
	
	@Override
	protected void afterall(HttpServletRequest request, ViewFormModel model) {
//		for (Cell cell : this.datas) {
//			cell.getDisp().put("status", Status.valueOf(cell.getStatus()).getName());
//			cell.getDisp().put("usestatus", CellStatus.valueOf(cell.getUsestatus()).getName());
//			cell.getDisp().put("builddate", DateUtils.format(cell.getBuilddate()));
//		}
	}
	
	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "admin/cell/list";
	}
}