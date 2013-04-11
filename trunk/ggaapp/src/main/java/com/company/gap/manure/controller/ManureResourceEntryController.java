package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.EntryController;
import com.company.gap.base.model.FormModel;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("manure/resource")
public class ManureResourceEntryController extends EntryController {
	
	@Autowired
	private IManureResourceService resourceService;
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("resource", ManureResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "manure/resource/manureResourceEntry";
	}
	
	@RequestMapping("/checkResource")
	public @ResponseBody boolean checkResource(HttpServletRequest request){
		int type = NumberUtils.toInt(request.getParameter("type"));
		String resource_name = StringUtils.defaultString(request.getParameter("resource_name"));
		Map<String, Object> mResource = resourceService.findByTypeAndName(type, resource_name);
		return mResource == null || mResource.isEmpty();
	}
	

	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		resourceService.saveResource(model.getData());
		String type = request.getParameter("type");
		return "redirect:/manure/resource/list.html?type=" + type;
	}
	
	@RequestMapping("entry")
	public String entry(HttpServletRequest request, @RequestParam("resourceId") int resourceId) {
		Map<String, Object> data = this.resourceService.findResourceById(resourceId);
		int type = NumberUtils.toInt(ObjectUtils.toString(data.get("resource_type")));
		request.setAttribute("data", data);
		request.setAttribute("resource", ManureResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "manure/resource/manureResourceEntry";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("resourceId") int resourceId) {
		resourceService.delete(resourceId);
		String type = request.getParameter("type");
		return "redirect:/manure/resource/list.html?type=" + type;
	}
}