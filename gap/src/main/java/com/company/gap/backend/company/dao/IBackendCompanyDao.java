package com.company.gap.backend.company.dao;

import com.company.gap.backend.company.model.Company;
import com.company.gap.base.dao.IBaseDao;

public interface IBackendCompanyDao extends IBaseDao<Company> {
	
	boolean initCompanyDatabase(Integer id);
	
	Company findCompanyByCompanyNo(String companyNo);
}