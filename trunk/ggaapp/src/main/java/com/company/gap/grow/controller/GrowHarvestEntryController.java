package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.service.IGrowHarvestService;
import com.company.gap.grow.tab.THarvest;
import com.company.gap.grow.tab.TRegister;

@Controller
@RequestMapping("grow/harvest")
public class GrowHarvestEntryController extends EntryController {
	@Autowired
	private IGrowHarvestService harvestService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "grow/harvest/growHarvestEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("harvest_id") int harvest_id) {
		super.edit(request);
		Dto data = harvestService.findHarvestById(harvest_id);
		request.setAttribute("data", data);
		return "grow/harvest/growHarvestEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("harvest_id") int harvest_id) {
		super.disp(request);
		Dto data = harvestService.findHarvestById(harvest_id);
		request.setAttribute("data", data);
		return "grow/harvest/growHarvestEntry";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		Dto data = model.getData();
		int register_id = data.getInt(THarvest.REGISTERID);
		harvestService.save(data);
		return "redirect:/grow/harvest/list.html?register_id=" + register_id;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("harvest_id") int harvest_id) {
		harvestService.delete(harvest_id);
		String register_id = request.getParameter(TRegister.ID);
		return "redirect:/grow/harvest/list.html?register_id=" + register_id;
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute(TRegister.ID, request.getParameter(TRegister.ID));
	}
}
