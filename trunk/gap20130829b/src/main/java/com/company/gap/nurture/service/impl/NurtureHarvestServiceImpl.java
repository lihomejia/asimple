package com.company.gap.nurture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.nurture.dao.INurtureHarvestDao;
import com.company.gap.nurture.model.Harvest;
import com.company.gap.nurture.service.INurtureHarvestService;

@Service
public class NurtureHarvestServiceImpl extends BaseServiceImpl<Harvest> implements INurtureHarvestService {

	@Autowired
	private INurtureHarvestDao dao;

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