package com.company.gap.disinfectant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.disinfectant.component.DisinfectantResourceHelper;
import com.company.gap.disinfectant.enumeration.DisinfectantResourceType;
import com.company.gap.disinfectant.model.Resource;
import com.company.gap.disinfectant.service.IDisinfectantResourceService;

@Controller
@RequestMapping("admin/disinfectant/resource")
public class DisinfectantResourceEntryController extends BeanEntryController<Resource> {
	
	@Autowired
	private IDisinfectantResourceService service;
	
	@Override
	protected IBaseService<Resource> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/admin/disinfectant/resource/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/disinfectant/resource/disinfectantResourceEntry";
	}
	
	@Override
	public String save(HttpServletRequest request, Resource t) {
		DisinfectantResourceHelper.clearCache();
		try {
			
			return super.save(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			DisinfectantResourceType disinfectantResourceType = t.getType();
			request.setAttribute("resourceType", disinfectantResourceType);
			request.setAttribute("type", t.getType().toString());
			return this.toEntry(request);
		}
	}

	@Override
	public String update(HttpServletRequest request, Resource t) {
		DisinfectantResourceHelper.clearCache();
		try {
			return super.update(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			DisinfectantResourceType disinfectantResourceType = t.getType();
			request.setAttribute("resourceType", disinfectantResourceType);
			request.setAttribute("type", t.getType().toString());
			request.setAttribute("data", t);
			super.initialize(request);
			return this.toEntry(request);
		}
	}

	@Override
	public String delete(HttpServletRequest request, Integer id) {
		DisinfectantResourceHelper.clearCache();
		return super.delete(request, id);
	}

	@Override
	public String approve(HttpServletRequest request, Integer id) {
		DisinfectantResourceHelper.clearCache();
		return super.approve(request, id);
	}

	@Override
	public String nullify(HttpServletRequest request, Integer id) {
		DisinfectantResourceHelper.clearCache();
		return super.nullify(request, id);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", DisinfectantResourceType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Resource t) {
		super.initializeEdit(request, t);
		DisinfectantResourceType disinfectantResourceType = t.getType();
		request.setAttribute("resourceType", disinfectantResourceType);
		request.setAttribute("type", disinfectantResourceType.toString());
	}
}