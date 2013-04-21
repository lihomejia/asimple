package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("cell")
public class CellEntryController extends BeanEntryController<Cell> {
	
	@Autowired
	private ICellService service;
	
	@Override
	protected IBaseService<Cell> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/cell/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "cell/entry";
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Cell t) {
		t.get__disp().put("builddate", DateUtils.format(t.getBuilddate()));
		super.initializeEdit(request, t);
	}
}