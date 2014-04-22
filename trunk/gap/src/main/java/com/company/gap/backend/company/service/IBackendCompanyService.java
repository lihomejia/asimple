package com.company.gap.backend.company.service;

import com.company.gap.backend.company.model.Company;
import com.company.gap.base.service.IBaseService;

public interface IBackendCompanyService extends IBaseService<Company> {
	
	Company findCompanyByCompanyNo(String companyNo);
	
}