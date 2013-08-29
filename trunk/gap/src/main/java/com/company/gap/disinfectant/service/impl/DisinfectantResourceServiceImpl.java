package com.company.gap.disinfectant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.disinfectant.dao.IDisinfectantResourceDao;
import com.company.gap.disinfectant.model.Resource;
import com.company.gap.disinfectant.service.IDisinfectantResourceService;

@Service
public class DisinfectantResourceServiceImpl extends BaseServiceImpl<Resource> implements IDisinfectantResourceService {

	@Autowired
	private IDisinfectantResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}
}