package com.company.gap.medicine.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.medicine.component.MedicineResourceHelper;
import com.company.gap.medicine.enumeration.MedicineResourceType;
import com.company.gap.medicine.model.InStock;
import com.company.gap.medicine.service.IMedicineInStockService;
import com.company.gap.system.service.IUserService;
import com.company.gap.system.service.impl.ServiceContext;

@Controller
@RequestMapping("admin/medicine/instock")
public class MedicineInStockEntryController extends BeanEntryController<InStock> {

	@Autowired
	private IMedicineInStockService service;
	
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<InStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/medicine/instock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/medicine/instock/medicineInStockEntry";
	}
	
	
	
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		InStock t = new InStock();
		t.setInuserId(ServiceContext.getLoginId());
		t.getDisp().put("inuserId", ServiceContext.getUserName());
		
		request.setAttribute("data", t);
		super.initializeAdd(request);
	}

	@Override
	protected void initializeEdit(HttpServletRequest request, InStock t) {
		Dto disp = t.getDisp();
		disp.put("indate", DateUtils.format(t.getIndate()));
		disp.put("expirydate", DateUtils.format(t.getExpirydate()));
		disp.put("inuserId", userService.findNameById(t.getInuserId()));
		super.initializeEdit(request, t);
	}
	
	@Override
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
		request.setAttribute("nameList", 	MedicineResourceHelper.getList(MedicineResourceType.PM));
		request.setAttribute("specList", 	MedicineResourceHelper.getList(MedicineResourceType.GG));
		request.setAttribute("batchList", 	MedicineResourceHelper.getList(MedicineResourceType.SCPH));
		request.setAttribute("producerList",MedicineResourceHelper.getList(MedicineResourceType.SCS));
		request.setAttribute("kindList", 	MedicineResourceHelper.getList(MedicineResourceType.ZL));
	}
}