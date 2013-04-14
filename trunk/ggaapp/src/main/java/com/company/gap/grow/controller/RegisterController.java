package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IRegisterService;

@Controller
@RequestMapping("grow/register")
public class RegisterController extends EntryController {
	
	@Autowired
	private ICellService cellService;
	@Autowired
	private IRegisterService registerService;
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		request.setAttribute("cellList", 	cellService.findUsableList());
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Register register = registerService.findById(id);
		Cell cell = cellService.findById(register.getCellId());
		register.get__added().put("register_cellid", cell.getCode());
		request.setAttribute("data", register);
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		return result;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, Register register) {
		registerService.save(register);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		registerService.approve(id);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		registerService.nullify(id);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("complete")
	public String complete(HttpServletRequest request, @RequestParam("id") int id) {
		registerService.complete(id);
		return "redirect:/grow/process/list.html";
	}
	
	@RequestMapping("archive")
	public String archive(HttpServletRequest request, @RequestParam("id") int id) {
		registerService.archive(id);
		return "redirect:/grow/completed/list.html";
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
	}
}
