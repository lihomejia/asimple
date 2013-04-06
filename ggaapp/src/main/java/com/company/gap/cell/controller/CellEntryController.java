package com.company.gap.cell.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.service.ICellService;
import com.company.gap.cell.tab.TCell;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("cell")
public class CellEntryController extends EntryController {
	
	@Autowired
	private ICellService cellService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "cell/entry";
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		super.save(request);
		cellService.saveCell(model.getData());
		return "redirect:/cell/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("cellId") int cellId) {
		super.edit(request);
		Map<String, Object> data = this.cellService.findCellById(cellId);
		data.put(TCell.CDATE, DateUtils.format(data.get(TCell.CDATE)));
		request.setAttribute("data", data);
		return "cell/entry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("cellId") int cellId) {
		super.disp(request);
		Map<String, Object> data = this.cellService.findCellById(cellId);
		data.put(TCell.CDATE, DateUtils.format(data.get(TCell.CDATE)));
		request.setAttribute("data", data);
		return "cell/entry";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("cellId") int cellId) {
		super.delete(request);
		cellService.delete(cellId);
		return "redirect:/cell/list.html";
	}
}