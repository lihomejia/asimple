package com.company.gap.medicine.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.medicine.component.MedicineResourceHelper;
import com.company.gap.medicine.enumeration.MedicineResourceType;
import com.company.gap.medicine.model.Resource;
import com.company.gap.medicine.service.IMedicineResourceService;

@Controller
@RequestMapping("admin/medicine/resource")
public class MedicineResourceEntryController extends BeanEntryController<Resource> {
	
	@Autowired
	private IMedicineResourceService service;
	
	@Override
	protected IBaseService<Resource> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		String type = request.getParameter("type");
		return "redirect:/admin/medicine/resource/list.html?type=" + type;
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/medicine/resource/medicineResourceEntry";
	}
	
	@Override
	public String save(HttpServletRequest request, Resource t) {
		MedicineResourceHelper.clearCache();
		try {
			
			return super.save(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			MedicineResourceType medicineResourceType = t.getType();
			request.setAttribute("resourceType", medicineResourceType);
			request.setAttribute("type", t.getType().toString());
			return this.toEntry(request);
		}
	}

	@Override
	public String update(HttpServletRequest request, Resource t) {
		MedicineResourceHelper.clearCache();
		try {
			return super.update(request, t);
		} catch (DuplicateKeyException e) {
			request.setAttribute("errormsg", "重复的名称");
			MedicineResourceType medicineResourceType = t.getType();
			request.setAttribute("resourceType", medicineResourceType);
			request.setAttribute("type", t.getType().toString());
			request.setAttribute("data", t);
			super.initialize(request);
			return this.toEntry(request);
		}
	}

	@Override
	public String delete(HttpServletRequest request, Integer id) {
		MedicineResourceHelper.clearCache();
		return super.delete(request, id);
	}

	@Override
	public String approve(HttpServletRequest request, Integer id) {
		MedicineResourceHelper.clearCache();
		return super.approve(request, id);
	}

	@Override
	public String nullify(HttpServletRequest request, Integer id) {
		MedicineResourceHelper.clearCache();
		return super.nullify(request, id);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initialize(request);
		String type = request.getParameter("type");
		request.setAttribute("resourceType", MedicineResourceType.valueOf(type));
		request.setAttribute("type", type);
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, Resource t) {
		super.initializeEdit(request, t);
		MedicineResourceType medicineResourceType = t.getType();
		request.setAttribute("resourceType", medicineResourceType);
		request.setAttribute("type", medicineResourceType.toString());
	}
}