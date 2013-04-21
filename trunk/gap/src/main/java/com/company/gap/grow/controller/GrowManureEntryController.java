package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Manure;
import com.company.gap.grow.service.IGrowManureService;

@Controller
@RequestMapping("grow/manure")
public class GrowManureEntryController extends EntryController {

	@Autowired
	private IGrowManureService manureService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "grow/manure/growManureEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Manure manure = manureService.findById(id);
		manure.get__disp().put("usedate", DateUtils.format(manure.getUsedate()));
		request.setAttribute("data", manure);
		return "grow/manure/growmanureEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		return result;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, Manure manure) {
		int registerId = manure.getRegisterId();
		manureService.save(manure);
		return "redirect:/grow/manure/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") int id) {
		manureService.deleteById(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/manure/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		manureService.approve(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/manure/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		manureService.nullify(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/manure/list.html?registerId=" + registerId;
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}
