package com.company.gap.backend.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.backend.company.dao.IBackendCompanyDao;
import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.util.TenTo36;

@Service
public class BackendCompanyServiceImpl extends BaseServiceImpl<Company> implements IBackendCompanyService {

	@Autowired
	private IBackendCompanyDao dao;
	
	@Override
	public IBaseDao<Company> get() {
		return this.dao;
	}
	
	
	@Override
	public int save(Company t) {
		int id = get().insert(t);
		
		String innercode = TenTo36.baseString(id, 36);
		while (innercode.length() < 3) {
			innercode = "0" + innercode;
		}
		innercode = "A" + innercode;
		
		Company c = new Company();
		c.setId(id);
		c.setInnercode(innercode);
		get().update(c);
		
		return id;
	}
	
	
	@Override
	public int approve(Integer id) {
		
		int ret = super.approve(id);
		
		if (dao.initCompanyDatabase(id)) {
			return ret;
		}
		
		return 0;
	}

	@Override
	public Company findCompanyByCompanyNo(String companyNo) {
		return dao.findCompanyByCompanyNo(companyNo);
	}
	
	
}