package com.company.gap.manure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.resource.service.IResourceService;

@Controller
@RequestMapping("manure/resource")
public class ManureResourceController extends ViewController {
	
	@Autowired
	private IResourceService resourceService;

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		searcher.addSf("resource_cate", Op.EQ, "1");
		
		String type = request.getParameter("type");
		searcher.addSf("resource_type", Op.EQ, type);
		
		searcher.setTable("t_input_resource");
	}

	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		return listView(NumberUtils.toInt(type));
	}
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		String type = request.getParameter("type");
		return entryView(NumberUtils.toInt(type));
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
		String type = ObjectUtils.toString(data.get("resource_type"));
		request.setAttribute("data", data);
		return entryView(NumberUtils.toInt(type));
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("resourceId") int resourceId) {
		resourceService.delete(resourceId);
		String type = request.getParameter("type");
		return "redirect:/manure/resource/list.html?type=" + type;
	}
	
	private String entryView(int type) {
		switch (type) {
			case 1 : return "manure/manureNameEntry";
			case 2 : return "manure/manureSizeEntry";
			case 3 : return "manure/manureBatchEntry";
			case 4 : return "manure/manureProducerEntry";
			case 5 : return "manure/manureKindEntry";
			default :return "";
		}
	}
	
	private String listView(int type) {
		switch (type) {
			case 1 : return "manure/manureNameList";
			case 2 : return "manure/manureSizeList";
			case 3 : return "manure/manureBatchList";
			case 4 : return "manure/manureProducerList";
			case 5 : return "manure/manureKindList";
			default :return "";
		}
	}
}