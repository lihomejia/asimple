package com.company.gap.manure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.model.Resource;
import com.company.gap.manure.service.IManureResourceService;

@Service
public class ManureResourceServiceImpl extends BaseServiceImpl<Resource> implements IManureResourceService {

	@Autowired
	private IManureResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}
}