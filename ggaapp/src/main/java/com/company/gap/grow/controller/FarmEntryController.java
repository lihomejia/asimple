package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.grow.model.Farm;
import com.company.gap.grow.service.IFarmService;

@Controller
@RequestMapping("grow/farm")
public class FarmEntryController extends EntryController {

	@Autowired
	private IFarmService farmService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "grow/farm/growFarmEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Farm farm = farmService.findById(id);
		request.setAttribute("data", farm);
		return "grow/farm/growFarmEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		return result;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, Farm farm) {
		int registerId = farm.getRegisterId();
		farmService.save(farm);
		return "redirect:/grow/farm/list.html?registerId=" + registerId;
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}
