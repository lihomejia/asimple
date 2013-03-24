package com.company.gap.pesticide.controller;

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

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/resource")
public class PesticideResourceController extends ViewController {
	
	@Autowired
	private IPesticideResourceService resourceService;
	
	
	@Override
	protected void preparing(HttpServletRequest request, ViewFormModel model) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("type", type);
		request.setAttribute("resource", PesticideResourceType.valueOf(type));
	}

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		searcher.addSf("resource_type", Op.EQ, type);
		searcher.setTable("t_pesticide_resource");
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "pesticide/resource/pesticideResourceList";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		int type = NumberUtils.toInt(request.getParameter("type"));
		request.setAttribute("resource", PesticideResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "pesticide/resource/pesticideResourceEntry";
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
		return "redirect:/pesticide/resource/list.html?type=" + type;
	}
	
	@RequestMapping("entry")
	public String entry(HttpServletRequest request, @RequestParam("resourceId") int resourceId) {
		Map<String, Object> data = this.resourceService.findResourceById(resourceId);
		int type = NumberUtils.toInt(ObjectUtils.toString(data.get("resource_type")));
		request.setAttribute("data", data);
		request.setAttribute("resource", PesticideResourceType.valueOf(type));
		request.setAttribute("type", type);
		return "pesticide/resource/pesticideResourceEntry";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("resourceId") int resourceId) {
		resourceService.delete(resourceId);
		String type = request.getParameter("type");
		return "redirect:/pesticide/resource/list.html?type=" + type;
	}
}