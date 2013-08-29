package com.company.gap.resource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.resource.component.DictHelper;
import com.company.gap.resource.enumeration.DictType;
import com.company.gap.resource.model.Dict;
import com.company.gap.resource.service.IDictService;

@Controller
@RequestMapping("admin/resource/dict")
public class DictEntryController extends BeanEntryController<Dict> {

	@Autowired
	private IDictService service;
	
	@Override
	protected IBaseService<Dict> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/admin/resource/dict/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/resource/dict/entry";
	}
	
	
	@Override
	public String save(HttpServletRequest request, Dict t) {
		DictHelper.clearCache();
		try {
			
			return super.save(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			DictType dictType = t.getType();
			request.setAttribute("dictType", dictType);
			request.setAttribute("type", t.getType().toString());
			return this.toEntry(request);
		}
	}

	@Override
	public String update(HttpServletRequest request, Dict t) {
		DictHelper.clearCache();
		try {
			return super.update(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			DictType dictType = t.getType();
			request.setAttribute("dictType", dictType);
			request.setAttribute("type", t.getType().toString());
			request.setAttribute("data", t);
			super.initialize(request);
			return this.toEntry(request);
		}
	}

	@Override
	public String delete(HttpServletRequest request, Integer id) {
		DictHelper.clearCache();
		return super.delete(request, id);
	}

	@Override
	public String approve(HttpServletRequest request, Integer id) {
		DictHelper.clearCache();
		return super.approve(request, id);
	}

	@Override
	public String nullify(HttpServletRequest request, Integer id) {
		DictHelper.clearCache();
		return super.nullify(request, id);
	}

	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("dictType", DictType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Dict t) {
		super.initializeEdit(request, t);
		DictType dictType = t.getType();
		request.setAttribute("dictType", dictType);
		request.setAttribute("type", dictType.toString());
	}
}
