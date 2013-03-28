package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.service.IGrowRegisterService;

@Controller
@RequestMapping("grow/register")
public class GrowRegisterController extends ViewController {
	
	@Autowired
	private ICellService cellService;
	
	@Autowired
	private IGrowRegisterService registerService;
	
	
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		_action = ACT_ADD;
		request.setAttribute("register", new GrowRegister());
		this.initData(request);
		
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		_action = ACT_EDIT;
		this.initData(request);
		request.setAttribute("register", registerService.findGrowRegister(register_id));
		return "grow/register/growRegisterEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("register_id") int register_id) {
		_action = ACT_DISP;
		this.initData(request);
		request.setAttribute("register", registerService.findGrowRegister(register_id));
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
	
	private void initData(HttpServletRequest request) {
		request.setAttribute(ACT_NAME, 		_action);
		request.setAttribute("cellList", 	cellService.findAllProductionCell());
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return null;
	}
}
