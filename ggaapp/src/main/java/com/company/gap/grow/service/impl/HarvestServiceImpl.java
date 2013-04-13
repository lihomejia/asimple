package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IHarvestDao;
import com.company.gap.grow.model.Harvest;
import com.company.gap.grow.service.IHarvestService;

@Service
public class HarvestServiceImpl extends BaseServiceImpl<Harvest> implements IHarvestService {

	@Autowired
	private IHarvestDao dao;

	@Override
	protected IBaseDao<Harvest> get() {
		return this.dao;
	}
	
	
}