package com.company.gap.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;
import com.company.gap.info.service.IInfoService;

@Controller
@RequestMapping("web")
public class IndexController {
	
	@Autowired
	private IInfoService infoService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		
		Map<InfoType, List<Info>> infos = infoService.queryGroup();
		for (Entry<InfoType, List<Info>> e : infos.entrySet()) {
			request.setAttribute(e.getKey().toString(), e.getValue());
		}
		
		return "web/index";
	}
}
