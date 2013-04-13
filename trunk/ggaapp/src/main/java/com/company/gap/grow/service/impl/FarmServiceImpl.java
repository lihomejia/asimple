package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IFarmDao;
import com.company.gap.grow.model.Farm;
import com.company.gap.grow.service.IFarmService;

@Service
public class FarmServiceImpl extends BaseServiceImpl<Farm> implements IFarmService {

	@Autowired
	private IFarmDao dao;

	@Override
	protected IBaseDao<Farm> get() {
		return this.dao;
	}
	
	
}