package com.company.gap.grow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IGrowManureDao;
import com.company.gap.grow.model.Manure;
import com.company.gap.grow.service.IGrowManureService;

@Service
public class GrowManureServiceImpl extends BaseServiceImpl<Manure> implements IGrowManureService {

	@Autowired
	private IGrowManureDao dao;
	
	@Override
	protected IBaseDao<Manure> get() {
		return this.dao;
	}
	
	@Override
	public List<Manure> findByRegisterId(Integer registerId) {
		Manure t = new Manure();
		t.setRegisterId(registerId);
		return this.findList(t);
	}

}
