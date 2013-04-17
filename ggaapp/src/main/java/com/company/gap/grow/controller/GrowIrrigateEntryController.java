package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Irrigate;
import com.company.gap.grow.service.IGrowIrrigateService;

@Controller
@RequestMapping("grow/irrigate")
public class GrowIrrigateEntryController extends EntryController {

	@Autowired
	private IGrowIrrigateService irrigateService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "grow/irrigate/growIrrigateEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Irrigate irrigate = irrigateService.findById(id);
		irrigate.get__added().put("date", DateUtils.format(irrigate.getDate()));
		request.setAttribute("data", irrigate);
		return "grow/irrigate/growIrrigateEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		
		return result;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, Irrigate irrigate) {
		int registerId = irrigate.getRegisterId();
		irrigateService.save(irrigate);
		return "redirect:/grow/irrigate/list.html?registerId=" + registerId;
	}
	
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") int id) {
		irrigateService.deleteById(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/irrigate/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		irrigateService.approve(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/irrigate/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		irrigateService.nullify(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/irrigate/list.html?registerId=" + registerId;
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}
