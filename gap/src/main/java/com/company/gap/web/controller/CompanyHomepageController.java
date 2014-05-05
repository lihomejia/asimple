package com.company.gap.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.LocalContext;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;
import com.company.gap.cinfo.service.ICinfoService;
import com.company.gap.system.model.User;

@Controller
@RequestMapping
public class CompanyHomepageController {

	@Autowired
	private ICinfoService infoService;
	
	@Autowired
	private IBackendCompanyService backendCompanyService;
	
	@RequestMapping(value="company/{companyno}")
	public String index(HttpServletRequest request, @PathVariable("companyno") String companyno) {
		request.setAttribute("companyno", "companyno");
		
		Company c = backendCompanyService.findCompanyByCompanyNo(companyno);
		
		User tmpUser = new User();
		tmpUser.setCompanyId(c.getInnercode());
		LocalContext.setUser(tmpUser);
		
		Map<CinfoType, List<Cinfo>> infos = infoService.queryGroup();
		for (Entry<CinfoType, List<Cinfo>> e : infos.entrySet()) {
			request.setAttribute(e.getKey().toString(), e.getValue());
		}
		
		return "web/company/index";
	}
}
