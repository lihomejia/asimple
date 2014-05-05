package com.company.gap.web.info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.LocalContext;
import com.company.gap.base.controller.BeanViewController;
import com.company.gap.base.dao.search.Op;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;
import com.company.gap.cinfo.service.ICinfoService;
import com.company.gap.system.model.User;

@Controller
@RequestMapping("company/{companyno}/cinfo")
public class CinfoController extends BeanViewController<Cinfo> {
	
	@Autowired
	private IBackendCompanyService backendCompanyService;
	
	@Autowired
	private ICinfoService service;
	
	@RequestMapping("list2")
	public String list2(HttpServletRequest request, @PathVariable("companyno") String companyno, ViewFormModel model) {
		request.setAttribute("companyno", "companyno");
		Company c = backendCompanyService.findCompanyByCompanyNo(companyno);
		
		User tmpUser = new User();
		tmpUser.setCompanyId(c.getInnercode());
		LocalContext.setUser(tmpUser);
		return super.execute(request, model);
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, @PathVariable("companyno") String companyno, Integer id) {
		request.setAttribute("companyno", "companyno");
		Company c = backendCompanyService.findCompanyByCompanyNo(companyno);
		
		User tmpUser = new User();
		tmpUser.setCompanyId(c.getInnercode());
		LocalContext.setUser(tmpUser);
		
		Cinfo info = service.findById(id);
		request.setAttribute("info", info);
		
		return "web/company/cinfo/cinfoDetail";
	}
	
	

	@Override
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model) {
		String type = request.getParameter("type");
		CinfoType infoType = CinfoType.valueOf(type);
		searcher.addSf("type", Op.EQ, type);
		request.setAttribute("infoType", infoType);
	}




	@Override
	protected String viewResolver(HttpServletRequest request, ViewFormModel model) {
		return "web/company/cinfo/cinfoList";
	}
}
