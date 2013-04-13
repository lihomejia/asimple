package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.EntryController;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.Resource;
import com.company.gap.manure.service.IResourceService;

@Controller
@RequestMapping("manure/resource")
public class ResourceEntryController extends EntryController {
	
	@Autowired
	private IResourceService resourceService;
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("resource", ResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "manure/resource/manureResourceEntry";
	}
	
	@RequestMapping("/checkResource")
	public @ResponseBody boolean checkResource(HttpServletRequest request){
		int type = NumberUtils.toInt(request.getParameter("type"));
		String name = StringUtils.defaultString(request.getParameter("name"));
		Resource resource = resourceService.findByTypeAndName(type, name);
		return resource == null;
	}
	

	@RequestMapping("save")
	public String save(HttpServletRequest request, Resource resource) {
		resourceService.save(resource);
		String type = request.getParameter("type");
		return "redirect:/manure/resource/list.html?type=" + type;
	}
	
	@RequestMapping("entry")
	public String entry(HttpServletRequest request, @RequestParam("id") int id) {
		Resource data = this.resourceService.findById(id);
		int type = data.getType();
		request.setAttribute("data", data);
		request.setAttribute("resource", ResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "manure/resource/manureResourceEntry";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") int id) {
		resourceService.deleteById(id);
		String type = request.getParameter("type");
		return "redirect:/manure/resource/list.html?type=" + type;
	}
}