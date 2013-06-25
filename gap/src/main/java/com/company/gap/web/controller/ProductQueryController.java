package com.company.gap.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.util.DateUtils;
import com.company.gap.base.util.xmlmodel.gap.RecordRoot;
import com.company.gap.base.util.xmlmodel.gap.TableInfo;
import com.company.gap.base.util.xmlmodel.gap.TableList;
import com.company.gap.grow.model.Farm;
import com.company.gap.grow.model.Harvest;
import com.company.gap.grow.model.Irrigate;
import com.company.gap.grow.model.Manure;
import com.company.gap.grow.model.Pesticide;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IGrowFarmService;
import com.company.gap.grow.service.IGrowHarvestService;
import com.company.gap.grow.service.IGrowIrrigateService;
import com.company.gap.grow.service.IGrowManureService;
import com.company.gap.grow.service.IGrowPesticideService;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.resource.component.DictHelper;

@Controller
@RequestMapping("product/query")
public class ProductQueryController {
	
	@Autowired
	private IGrowRegisterService registerService;
	@Autowired
	private IGrowFarmService farmService;
	@Autowired
	private IGrowIrrigateService irrigateService;
	@Autowired
	private IGrowManureService manureService;
	@Autowired
	private IGrowPesticideService pesticideService;
	@Autowired
	private IGrowHarvestService harvestService;
	
	
	@RequestMapping("doHtml5")
	public String doHtml5(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"), 0);
		
		Register register = registerService.findById(id);
		if (register == null) register = new Register();
		
		RecordRoot root = new RecordRoot();

		{
			TableInfo baseInfo = new TableInfo();
			root.addChild("基本信息", baseInfo);

			baseInfo.addRow("序&nbsp;&nbsp;列&nbsp;&nbsp;号:", ObjectUtils.toString(register.getId()));
			baseInfo.addRow("产品名称:", DictHelper.getText(register.getProductId()));
			baseInfo.addRow("生产厂家:", "北京世外桃源农业科技");
			baseInfo.addRow("生产日期:", "2013-03-06");
			baseInfo.addRow("出厂日期:", "2013-04-02");
		}
		{
			TableList tableList = new TableList();
			root.addChild("灌溉记录", tableList);
			List<Irrigate> irrigates = irrigateService.findByRegisterId(id);
			for (Irrigate irrigate : irrigates) {
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", DateUtils.format(irrigate.getDate()));
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", irrigate.getManager());
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", StringUtils.defaultString(irrigate.getComment()));
			}
		}
		{
			TableList tableList = new TableList();
			root.addChild("农事活动记录", tableList);
			List<Farm> farms = farmService.findByRegisterId(id);
			for (Farm farm : farms) {
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", DateUtils.format(farm.getActivitydate()));
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", farm.getManager());
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", StringUtils.defaultString(farm.getComment()));
			}
		}
		{
			TableList tableList = new TableList();
			root.addChild("施肥记录", tableList);
			List<Manure> farms = manureService.findByRegisterId(id);
			for (Manure manure : farms) {
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", DateUtils.format(manure.getUsedate()));
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", manure.getUseperson());
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", StringUtils.defaultString(manure.getComment()));
			}
		}
		{
			TableList tableList = new TableList();
			root.addChild("农药使用记录", tableList);
			List<Pesticide> farms = pesticideService.findByRegisterId(id);
			for (Pesticide pesticide : farms) {
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", DateUtils.format(pesticide.getUsedate()));
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", pesticide.getUseperson());
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", StringUtils.defaultString(pesticide.getComment()));
			}
		}
		{
			TableList tableList = new TableList();
			root.addChild("收获记录", tableList);
			List<Harvest> farms = harvestService.findByRegisterId(id);
			for (Harvest harvest : farms) {
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", DateUtils.format(harvest.getOperatedate()));
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", harvest.getRespmanager());
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", StringUtils.defaultString(harvest.getComment()));
			}
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		StringBuilder sb = new StringBuilder();
		root.writer(sb);
		request.setAttribute("content", sb);
		
		return "result";
	}
	
	
}
