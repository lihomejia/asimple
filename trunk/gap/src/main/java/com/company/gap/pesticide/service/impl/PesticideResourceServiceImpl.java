package com.company.gap.pesticide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.pesticide.dao.IPesticideResourceDao;
import com.company.gap.pesticide.model.Resource;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Service
public class PesticideResourceServiceImpl extends BaseServiceImpl<Resource> implements IPesticideResourceService {

	@Autowired
	private IPesticideResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}
}