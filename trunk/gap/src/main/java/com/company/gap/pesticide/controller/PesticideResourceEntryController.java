package com.company.gap.pesticide.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.pesticide.component.PesticideResourceHelper;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.model.Resource;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Controller
@RequestMapping("pesticide/resource")
public class PesticideResourceEntryController extends BeanEntryController<Resource> {
	
	@Autowired
	private IPesticideResourceService service;
	
	@Override
	protected IBaseService<Resource> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/pesticide/resource/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "pesticide/resource/pesticideResourceEntry";
	}
	
	@Override
	public String save(HttpServletRequest request, Resource t) {
		PesticideResourceHelper.clearCache();
		try {
			
			return super.save(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			PesticideResourceType pesticideResourceType = t.getType();
			request.setAttribute("resourceType", pesticideResourceType);
			request.setAttribute("type", t.getType().toString());
			return this.toEntry(request);
		}
	}

	@Override
	public String update(HttpServletRequest request, Resource t) {
		PesticideResourceHelper.clearCache();
		try {
			return super.update(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			PesticideResourceType pesticideResourceType = t.getType();
			request.setAttribute("resourceType", pesticideResourceType);
			request.setAttribute("type", t.getType().toString());
			request.setAttribute("data", t);
			super.initialize(request);
			return this.toEntry(request);
		}
	}

	@Override
	public String delete(HttpServletRequest request, Integer id) {
		PesticideResourceHelper.clearCache();
		return super.delete(request, id);
	}

	@Override
	public String approve(HttpServletRequest request, Integer id) {
		PesticideResourceHelper.clearCache();
		return super.approve(request, id);
	}

	@Override
	public String nullify(HttpServletRequest request, Integer id) {
		PesticideResourceHelper.clearCache();
		return super.nullify(request, id);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", PesticideResourceType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Resource t) {
		super.initializeEdit(request, t);
		PesticideResourceType pesticideResourceType = t.getType();
		request.setAttribute("resourceType", pesticideResourceType);
		request.setAttribute("type", pesticideResourceType.toString());
	}
}