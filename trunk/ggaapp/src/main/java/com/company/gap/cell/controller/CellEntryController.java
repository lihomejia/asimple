package com.company.gap.cell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.model.Status;
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
public class CellEntryController extends EntryController {
	
	@Autowired
	private ICellService cellService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "cell/entry";
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, Cell cell) {
		super.save(request);
		cellService.save(cell);
		return "redirect:/cell/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") Integer id) {
		super.edit(request);
		Cell data = this.cellService.findById(id);
		data.get__added().put("builddate", DateUtils.format(data.getBuilddate()));
		request.setAttribute("data", data);
		return "cell/entry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		super.disp(request);
		Cell data = this.cellService.findById(id);
		data.get__added().put("builddate", DateUtils.format(data.getBuilddate()));
		request.setAttribute("data", data);
		return "cell/entry";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") int id) {
		super.delete(request);
		cellService.deleteById(id);
		return "redirect:/cell/list.html";
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		cellService.updateStatus(id, Status.APPROVED.getStatus());
		return "redirect:/cell/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		cellService.updateStatus(id, Status.NULLIFY.getStatus());
		return "redirect:/cell/list.html";
	}
	
}