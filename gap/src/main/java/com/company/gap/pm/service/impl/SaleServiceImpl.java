package com.company.gap.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.pm.dao.impl.ISaleDao;
import com.company.gap.pm.model.Sale;
import com.company.gap.pm.service.ISaleService;

@Service
public class SaleServiceImpl extends BaseServiceImpl<Sale> implements ISaleService {

	@Autowired
	private ISaleDao<Sale> dao;
	

	@Override
	protected IBaseDao<Sale> get() {
		return this.dao;
	}

}
