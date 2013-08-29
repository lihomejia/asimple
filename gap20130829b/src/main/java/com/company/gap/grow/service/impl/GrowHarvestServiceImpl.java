package com.company.gap.grow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IGrowHarvestDao;
import com.company.gap.grow.model.Harvest;
import com.company.gap.grow.service.IGrowHarvestService;

@Service
public class GrowHarvestServiceImpl extends BaseServiceImpl<Harvest> implements IGrowHarvestService {

	@Autowired
	private IGrowHarvestDao dao;

	@Override
	protected IBaseDao<Harvest> get() {
		return this.dao;
	}
	
	@Override
	public List<Harvest> findByRegisterId(Integer registerId) {
		Harvest t = new Harvest();
		t.setRegisterId(registerId);
		return this.findList(t);
	}
}