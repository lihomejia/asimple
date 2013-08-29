package com.company.gap.medicine.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.base.controller.BeanEntryController;
import com.company.gap.base.service.IBaseService;
import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.medicine.component.MedicineResourceHelper;
import com.company.gap.medicine.model.OutStock;
import com.company.gap.medicine.model.Stock;
import com.company.gap.medicine.service.IMedicineOutStockService;
import com.company.gap.medicine.service.IMedicineStockService;
import com.company.gap.system.service.IUserService;
import com.company.gap.system.service.impl.ServiceContext;

@Controller
@RequestMapping("admin/medicine/outstock")
public class MedicineOutStockEntryController extends BeanEntryController<OutStock> {
	
	@Autowired
	private IMedicineOutStockService service;
	@Autowired
	private IMedicineStockService stockService;
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private ICellService cellService;
	@Autowired
	private IUserService userService;
	
	@Override
	protected IBaseService<OutStock> get() {return this.service;}
	
	@Override
	protected String toList(HttpServletRequest request) {
		return "redirect:/admin/medicine/outstock/list.html";
	}
	
	@Override
	protected String toEntry(HttpServletRequest request) {
		return "admin/medicine/outstock/medicineOutStockEntry";
	}
	
	@RequestMapping("/checkOutStock")
	public @ResponseBody boolean checkOutStock(HttpServletRequest request){
		int stockId = NumberUtils.toInt(request.getParameter("stockId"));
		double quantity = NumberUtils.toDouble(request.getParameter("quantity"));
		Stock stock = stockService.findById(stockId);
		return (stock != null) && (stock.getQuantity() >= quantity);
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, OutStock t) {
		this.get().update(t);
		return this.toList(request);
	}
	
	@Override
	protected void initializeAdd(HttpServletRequest request) {
		super.initializeAdd(request);
		OutStock t = new OutStock();
		t.setOutuserId(ServiceContext.getLoginId());
		t.getDisp().put("outuserId", ServiceContext.getUserName());
		request.setAttribute("data", t);
		request.setAttribute("registerList", 	registerService.findListByGrowStatus(GrowStatus.GOING.getStatus()));
	}
	
	@Override
	protected void initializeEdit(HttpServletRequest request, OutStock t) {
		
		Dto disp = t.getDisp();
		
		disp.put("nameId", 		MedicineResourceHelper.getText(t.getNameId()));
		disp.put("specId", 		MedicineResourceHelper.getText(t.getSpecId()));
		disp.put("batchId", 	MedicineResourceHelper.getText(t.getBatchId()));
		disp.put("producerId", 	MedicineResourceHelper.getText(t.getProducerId()));
		
		Cell cell = cellService.findById(t.getCellId());
		disp.put("outdate", DateUtils.format(t.getOutdate()));
		disp.put("registerId", cell.getCode() + "&nbsp;" + cell.getLocation());
		disp.put("outuserId", userService.findNameById(t.getOutuserId()));
		super.initializeEdit(request, t);
	}
	
	
	protected void initialize(HttpServletRequest request) {
		super.initialize(request);
	}
}