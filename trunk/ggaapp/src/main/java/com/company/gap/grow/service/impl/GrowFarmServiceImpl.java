package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IGrowFarmDao;
import com.company.gap.grow.model.Farm;
import com.company.gap.grow.service.IGrowFarmService;

@Service
public class GrowFarmServiceImpl extends BaseServiceImpl<Farm> implements IGrowFarmService {

	@Autowired
	private IGrowFarmDao dao;

	@Override
	protected IBaseDao<Farm> get() {
		return this.dao;
	}
	
	
}