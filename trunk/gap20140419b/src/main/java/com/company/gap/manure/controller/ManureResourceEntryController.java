package com.company.gap.manure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.component.ManureResourceHelper;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.model.Resource;
import com.company.gap.manure.service.IManureResourceService;

@Controller
@RequestMapping("admin/manure/resource")
public class ManureResourceEntryController extends BeanEntryController<Resource> {
	
	@Autowired
	private IManureResourceService service;
	
	@Override
	protected IBaseService<Resource> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/admin/manure/resource/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/manure/resource/manureResourceEntry";
	}
	
	@Override
	public String save(HttpServletRequest request, Resource t) {
		ManureResourceHelper.clearCache();
		try {
			
			return super.save(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			ManureResourceType manureResourceType = t.getType();
			request.setAttribute("resourceType", manureResourceType);
			request.setAttribute("type", t.getType().toString());
			return this.toEntry(request);
		}
	}

	@Override
	public String update(HttpServletRequest request, Resource t) {
		ManureResourceHelper.clearCache();
		try {
			return super.update(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			ManureResourceType manureResourceType = t.getType();
			request.setAttribute("resourceType", manureResourceType);
			request.setAttribute("type", t.getType().toString());
			request.setAttribute("data", t);
			super.initialize(request);
			return this.toEntry(request);
		}
	}

	@Override
	public String delete(HttpServletRequest request, Integer id) {
		ManureResourceHelper.clearCache();
		return super.delete(request, id);
	}

	@Override
	public String approve(HttpServletRequest request, Integer id) {
		ManureResourceHelper.clearCache();
		return super.approve(request, id);
	}

	@Override
	public String nullify(HttpServletRequest request, Integer id) {
		ManureResourceHelper.clearCache();
		return super.nullify(request, id);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", ManureResourceType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Resource t) {
		super.initializeEdit(request, t);
		ManureResourceType manureResourceType = t.getType();
		request.setAttribute("resourceType", manureResourceType);
		request.setAttribute("type", manureResourceType.toString());
	}
}