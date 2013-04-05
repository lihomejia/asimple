package com.company.gap.grow.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.service.IGrowRegisterService;

@Controller
@RequestMapping("grow/register")
public class GrowRegisterController extends EntryController {
	
	@Autowired
	private ICellService cellService;
	@Autowired
	private IGrowRegisterService registerService;
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		request.setAttribute("register", 	new GrowRegister());
		request.setAttribute("cellList", 	cellService.findCellsByStatus(CellStatus.IDLE));
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		super.edit(request);
		GrowRegister register = registerService.findGrowRegister(register_id);
		Map<String, Object> cell = cellService.findCellById(register.getRegister_cellid());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("register_cellid__disp", cell.get("cell_code"));
		request.setAttribute("register", register);
		request.setAttribute("data", data);
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		super.disp(request);
		GrowRegister register = registerService.findGrowRegister(register_id);
		Map<String, Object> cell = cellService.findCellById(register.getRegister_cellid());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("register_cellid__disp", cell.get("cell_code"));
		request.setAttribute("register", register);
		request.setAttribute("data", data);
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, GrowRegister register) {
		registerService.save(register);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("auditing")
	public String auditing(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		registerService.auditing(register_id);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("complete")
	public String complete(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		registerService.complete(register_id);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("archive")
	public String archive(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		registerService.archive(register_id);
		return "redirect:/grow/completed/list.html";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		registerService.delete(register_id);
		return "redirect:/grow/process/list.html";
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
	}
}
