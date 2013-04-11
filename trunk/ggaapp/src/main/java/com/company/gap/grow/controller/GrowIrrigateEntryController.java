package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.model.FormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.service.IGrowIrrigateService;
import com.company.gap.grow.tab.TIrrigate;
import com.company.gap.grow.tab.TRegister;

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
	public String edit(HttpServletRequest request, @RequestParam("irrigate_id") int irrigate_id) {
		super.edit(request);
		Dto data = irrigateService.findIrrigateById(irrigate_id);
		request.setAttribute("data", data);
		return "grow/irrigate/growIrrigateEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("irrigate_id") int irrigate_id) {
		super.disp(request);
		Dto data = irrigateService.findIrrigateById(irrigate_id);
		request.setAttribute("data", data);
		return "grow/irrigate/growIrrigateEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		Dto data = model.getData();
		int register_id = data.getInt(TIrrigate.REGISTERID);
		irrigateService.save(data);
		return "redirect:/grow/irrigate/list.html?register_id=" + register_id;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("irrigate_id") int irrigate_id) {
		irrigateService.delete(irrigate_id);
		String register_id = request.getParameter(TRegister.ID);
		return "redirect:/grow/irrigate/list.html?register_id=" + register_id;
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute(TRegister.ID, request.getParameter(TRegister.ID));
	}
}
