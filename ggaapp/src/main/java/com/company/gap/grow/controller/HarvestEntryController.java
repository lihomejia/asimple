package com.company.gap.grow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.util.DateUtils;
import com.company.gap.grow.model.Harvest;
import com.company.gap.grow.service.IHarvestService;

@Controller
@RequestMapping("grow/harvest")
public class HarvestEntryController extends EntryController {
	@Autowired
	private IHarvestService harvestService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		super.add(request);
		return "grow/harvest/growHarvestEntry";
	}
	
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") int id) {
		super.edit(request);
		Harvest harvest = harvestService.findById(id);
		harvest.get__added().put("operatedate", DateUtils.format(harvest.getOperatedate()));
		request.setAttribute("data", harvest);
		return "grow/harvest/growHarvestEntry";
	}
	
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") int id) {
		String result = this.edit(request, id);
		super.disp(request);
		
		return result;
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, Harvest harvest) {
		int registerId = harvest.getRegisterId();
		harvestService.save(harvest);
		return "redirect:/grow/harvest/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") int id) {
		harvestService.deleteById(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/harvest/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") int id) {
		harvestService.approve(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/harvest/list.html?registerId=" + registerId;
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") int id) {
		harvestService.nullify(id);
		String registerId = request.getParameter("registerId");
		return "redirect:/grow/harvest/list.html?registerId=" + registerId;
	}
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("registerId", request.getParameter("registerId"));
	}
}